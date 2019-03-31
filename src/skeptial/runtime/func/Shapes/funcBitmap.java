package skeptial.runtime.func.Shapes;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.format.Time;
import android.util.Log;

public class funcBitmap {
	
	public static final float DRAG_THRESHOLD     = 20.0f;
	public static final float MIN_WIDTH_SELECT   = 10.0f;
	public static final float MIN_SCALE_SELECT   = 0.75f;
	public static final float WIDTH_SELECT_SHIFT = 30.0f;
	
	Bitmap AllBitmap1; 
	Bitmap AllBitmap2; 
	public Canvas AllCanvas; 
	public Canvas AllCanvas2;
	public Paint  paint;
	funcShape AnnotationPtr = null;
	public void SetOptions(float _width,float _height,Bitmap Layer1,Bitmap Layer2 ,Canvas Engine,Canvas Engine2,Paint paint ){
		AllBitmap1  = Layer1;
		AllBitmap2  = Layer2;
		AllCanvas   = Engine;
		AllCanvas2  = Engine2;
		this.paint  = paint; 
		width = _width;
		height = _height;
		
	}
	
	
	
	public List<funcShape> content = new ArrayList<funcShape>();
	public List<funcShape> RedoContent = new ArrayList<funcShape>();
	public List<funcShape> tempLayer  = new ArrayList<funcShape>();
	public float width,height;
	public Time CreateTime;
	public Time EndTime;
	public int BackColor = Color.BLACK;
	public boolean InEditMode=false;
	
	
	private funcShape tempLast = null;
	public void AddItem(funcShape obj){
		content.add(obj);
		tempLast = obj;
	}
	
	public void switchLasttoRedoStack(){
		if (content.size()>0){
			RedoContent.add(content.get(content.size()-1) );
			content.remove(content.size()-1);
		}
	}
	
	public void switchRedoStackToLast(){
		if (RedoContent.size()>0){
			content.add(RedoContent.get(RedoContent.size()-1) );
			RedoContent.remove(RedoContent.size()-1);
		}
	}
	public funcShape LastItem(){
	//for fastest Access
		return tempLast;
	}

	public void DrawLayer1(){
		//AllBitmap1.eraseColor(this.BackColor);
		AllCanvas.drawColor(this.BackColor);
		for (funcShape x : this.content) {
			//if (!x.inEditMode)
			x.Draw(AllCanvas, paint);
		}
		
		
		
		if (AnnotationPtr !=null)
			AnnotationPtr.Draw(AllCanvas, paint);
	}
	public void DrawLayer2(){
		AllBitmap2.eraseColor(0x00000000);
		//AllCanvas2.drawColor(0x00000000);
		//AllCanvas2.
		for (funcShape x : this.tempLayer) {
			//if (!x.inEditMode)
			x.Draw(AllCanvas2, paint);
		}
	}
	
	public double Distance (float x1,float y1,float x2,float y2){
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
	}
	
	public void MoveObjectToEditMode(funcShape obj){
		obj.inEditMode = true;
		InEditMode = true;
		
		funcRectangle rec = new funcRectangle(Color.BLUE);
		float pts [] = obj.GetMinBoundBox();
		rec.x1 = pts[0];
		rec.y1 = pts[1];
		rec.x2 = pts[2];
		rec.y2 = pts[3];
		rec.ParentHandle = obj;
		rec.scale = obj.scale;
		rec.translateX = obj.translateX;
		rec.translateY = obj.translateY;
		rec.Angle 	   = obj.Angle; 
		tempLayer.add(rec);
		AnnotationPtr = new funcTextAnnotation((int)width,(int)height,obj);
		
	}
	
	public void ReleaseObjectFromEditMode(funcShape obj){
		// null object means to pop the last selected object
		if (tempLayer.size()!=0)
		if (obj == null){
			tempLayer.get(tempLayer.size()-1).ParentHandle.inEditMode = false;
			tempLayer.remove(tempLayer.size()-1);
		}
		else{ 
			obj.inEditMode = false;
			
			for (funcShape x : tempLayer){
				if (x.ParentHandle == obj){
					tempLayer.remove(x);
					break;
				}
			}
		}
		if (tempLayer.size()==0){
			InEditMode = false;
			AnnotationPtr = null;
		}else{
			AnnotationPtr = new funcTextAnnotation((int)width,
												 (int)height,
												  tempLayer.get(tempLayer.size()-1).ParentHandle);
		}
	}

	public funcShape GetObjectOnPos (float x, float y){//TODO: need to find better algorithm
		float TempWidth =0.0f;
		float TempScale =1.0f;
		for (int i = content.size()-1 ; i >=0; i-- ){
			AllBitmap2.eraseColor(0x00000000);//transparent
			
			//temp width to increase the width for small objects because they are hard to select
			TempWidth = content.get(i).StrokeWidth;
			TempScale = content.get(i).scale;
			if (TempWidth <MIN_WIDTH_SELECT ||
				TempScale <MIN_SCALE_SELECT
					) content.get(i).StrokeWidth = TempWidth + WIDTH_SELECT_SHIFT;
			content.get(i).Draw(AllCanvas2, paint);
			content.get(i).StrokeWidth = TempWidth;
			
			Log.d("try get object", String.valueOf(i));
			if (AllBitmap2.getPixel((int)x , (int)y ) !=0 ){
				return content.get(i);
			}
		}
		
		return null;
	}
	
	public void SetBackColor(int Color){
		BackColor = Color;
	}
	public int GetBackColor(){
		return BackColor;
	}
	
	public void RemoveSelectedObjects(){
		List<funcShape> tmp = new ArrayList<funcShape>();
		for (funcShape x : content) {
			if (x.inEditMode){
				ReleaseObjectFromEditMode(x);
				tmp.add(x);
			}
			
		}
		for(funcShape x : tmp){
			content.remove(x);
			RedoContent.add(x);
		}

	}
}
