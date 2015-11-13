package com.hd.mapreduce.maxtemp;

import org.apache.hadoop.io.Text;

/**
 * @author Chunyun
 * 该类用于解析Ncdc的气象数据供mapreduce程序调用
 *
 */
public class NcdcRecordParser {
	private static final int MISSING_TEMPERATURE = 9999;
	private String year;
	private int airTemperature;
	private String quality;
	private String stationId;
	
	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}

	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public void parse(String record){
		year = record.substring(15, 19);
		String airTempatureString;
		if(record.charAt(87) == '+'){
			airTempatureString = record.substring(88, 92);
		}else {
			airTempatureString = record.substring(87, 92);
		}
		airTemperature = Integer.parseInt(airTempatureString);
		quality = record.substring(92, 93);
		String tmpId1 = record.substring(4, 10);
		String tmpId2 = record.substring(10, 15);
		String tmpId = tmpId1 + "-" + tmpId2;
		setStationId(tmpId);
	}
	
	public void parse(Text record) {
		parse(record.toString());
	}
	
	public boolean isValidTemperature() {
		return airTemperature != MISSING_TEMPERATURE && quality.matches("[01459]");	
	}
	
	public String getYear() {
		return year;
	}
	
	public int getAirTemperature(){
		return airTemperature;
	}
}
