package com.kh.project.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BoardListDto {
	private String memberNickname;
	private int boardNo;
	private String boardTitle;
	private int boardReadcount;
	private int boardLikecount;
	private int boardReplycount;
	private Date boardCtime;
	private Date boardUtime;
	private String boardWriter;
	private int boardGroup;
	private Integer boardParent;
	private int boardDepth;
	
	public String getBoardWriterString() {
		if(boardWriter == null) return "(탈퇴한사용자)";
		else return memberNickname;
	}
	
	public String getBoardCtimeString() {
		LocalDate current = LocalDate.now(); 
		LocalDate ctime = boardCtime.toLocalDate(); 
		if(current.isEqual(ctime)) {
			Timestamp stamp = new Timestamp(boardCtime.getTime());
			LocalDateTime time = stamp.toLocalDateTime();
			LocalTime result = time.toLocalTime();
			return result.format(DateTimeFormatter.ofPattern("HH:mm"));					
		}
		else {
			return ctime.toString();
		}
	}
	
}

