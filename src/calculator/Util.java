package calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;


public class Util {

	static String FILENAME="score.dat";
	public static String SPLITSTRING = "&HHS&";
	//创建Score
	public static void createScore() throws IOException {

		Score score=new Score();

		FileWriter writer = new FileWriter(FILENAME);
		writer.write(score.getRightAmount() + SPLITSTRING);
		writer.write(score.getWrongAmount() + SPLITSTRING);
		writer.write(score.getRadioAmount() + SPLITSTRING);
		writer.close();
	}
	//读取分数
	public static Score readScore() throws IOException, ParseException {

		File file = new File(FILENAME);
        if(!file.exists()){createScore();}   
		Score score=new Score();
		BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
		String line = reader.readLine();
		String []infos=line.split(SPLITSTRING);
		score.setRightAmount(Integer.valueOf(infos[0]));
		score.setWrongAmount(Integer.valueOf(infos[1]));
		score.setRadioAmount(Double.valueOf(infos[2]));

		return score;

	}
	//写分数
	public static void saveScore(Score score) throws IOException, ParseException {
		
		FileWriter writer = new FileWriter(FILENAME);
		writer.write(score.getRightAmount() + SPLITSTRING);
		writer.write(score.getWrongAmount() + SPLITSTRING);
		writer.write(score.getRadioAmount() + SPLITSTRING);
		
		writer.close();
	}

	/**
	 * 
	 * 获取目录下的所有文件名 By Hhs
	 */
	public static String[] getFileName(String path) {
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
}
