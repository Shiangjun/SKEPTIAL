// Xiangjun Peng

import java.util.*;

public class SketchImage {
	
	private int[][] Pixel;
	private BufferedImage Target;		
	private int ImgWidth = target.getWidth();
	private int ImgHeight = target.getHeight();
	private int ImgMinX = target.getMinX();
	private int ImgMinY = target.getMinY();
				
	
	SketchImage(String ImgName) {
		
			File ImgFile = new File(ImgName);
			Target = ImageIO.read(ImgFile);
	
			ImgWidth = target.getWidth();
			ImgHeight = target.getHeight();
			ImgMinX = target.getMinX();
			ImgMinY = target.getMinY();
			
	
	}
	
	public static int[][] ImgToPixel() {
	
		try {
	
			int[][] ImgDistribution = new int[ImgWidth - ImgMinX][ImgHeight - ImgMinY];

			for (int i = ImgMinX; i < ImgWidth; i++)
				for (int j = ImgMinY; j < ImgHeight; j++) {
					ImgDistribution[i-ImgMinX][j-ImgMinY] = target.getRGB(i,j);
					
			return target;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void OutputCSV() {
		
		try {
			
			BufferedWriter outCSV = new BufferedWriter(FileWriter("../data/log/demo.csv"));
			
			for (int i = ImgMinX; i < ImgWidth; i++)
				for (int j = ImgMinY; j < ImgHeight; j++)
					if (ImgDistribution[i][j] != 0)
						outCSV.write(i+","+j+"\n");
					
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CsvToShp() {
	
		try {
			
			BufferedReader inCSV = new BufferedReader(FileReader("../data/pre-process/demo.shp"));
			String temp = null;
			
			while (((temp = inCSV.readLine()) != EOF) {
			
					
			
			}
			
			inCSV.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	
	}
	
}
