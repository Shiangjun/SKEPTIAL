package skeptial.runtime.func;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
public class AboutDialog extends Dialog{
	private static Context mContext = null;
	
	private final  String Data = 
			"<h3>Skeptial</h3>" +
			"Version Test<br>" +
			"People: (Female First, alphabetically)<br>" +
	
			"<b>Xinyang Li</b><br>" +
			"<a href=\"mailto:zy22044@nottingham.edu.cn\">zy22044@nottingham.edu.cn</a><br> <br>" +
    
			"<b>Shuying Qiao</b><br>" +
			"<a href=\"mailto:zy22059@nottingham.edu.cn\">zy22059@nottingham.edu.cn</a><br> <br>" +
	
			"<b>Wenhao Du</b><br>" +
			"<a href=\"mailto:zy22028@nottingham.edu.cn\">zy22028@nottingham.edu.cn</a><br> <br>" +
    
			"<b>Zexi Liu</b><br>" +
			"<a href=\"mailto:zy22050@nottingham.edu.cn\">zy22050@nottingham.edu.cn</a><br> <br>" +
    
			"<b>Xiangjun PENG</b><br>" +
			"<a href=\"mailto:zy22056@nottingham.edu.cn\">zy22056@nottingham.edu.cn</a><br> <br>" +
	
			"<b>Wangbo Shen</b><br>" +
			"<a href=\"mailto:zy22061@nottingham.edu.cn\">zy22061@nottingham.edu.cn</a><br> <br>";
    
	
	private final String nfo = "Skeptial is a Group Software Engineering Project in University of Nottingham Ningbo China";
	
	public AboutDialog(Context context) {
		super(context);
		mContext = context;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.about_dialog);
		TextView tv = (TextView)findViewById(R.id.legal_text);
		tv.setText(nfo);
		tv = (TextView)findViewById(R.id.info_text);
		tv.setText(Html.fromHtml(Data));
		
		tv.setTextColor(tv.getTextColors().getDefaultColor());
		tv.setMovementMethod(LinkMovementMethod.getInstance());
		
		stripUnderlinesInHTML(tv);
		//tv.setLinkTextColor(Color.WHITE);
		
		//Linkify.addLinks(tv, Linkify.ALL);
	}
	
	private void stripUnderlinesInHTML(TextView textView) {
	    Spannable s = (Spannable)textView.getText();
	    URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
	    for (URLSpan span: spans) {
	        int start = s.getSpanStart(span);
	        int end = s.getSpanEnd(span);
	        s.removeSpan(span);
	        span = new URLSpanNoUnderline(span.getURL());
	        s.setSpan(span, start, end, 0);
	    }
	    textView.setText(s);
	}
	public class URLSpanNoUnderline extends URLSpan {
	    public URLSpanNoUnderline(String url) {
	        super(url);
	    }
	    @Override 
	    public void updateDrawState(TextPaint ds) {
	        super.updateDrawState(ds);
	        ds.setUnderlineText(false);
	    }
	}
    
}