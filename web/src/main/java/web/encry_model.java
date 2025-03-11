package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//모든 암호화는 byte단위
//문자를 암호화 변경을 하는 모듈
public class encry_model {
	public String dataencode(String word) { //base64 암호화
		
		Encoder ec = Base64.getEncoder(); 
		String security = ec.encodeToString(word.getBytes());
		
		return security;
	}
	
	public String datadecode(String word) { //base64 복호화(64바이트)
		Decoder dc = Base64.getDecoder(); 
		/*byte security[] = dc.decode(word);
		String security = new String(dec);*/
		
		String security = new String(dc.decode(word));
		
		return security;
	}
	
	//MD5 - 암호화기술 %02x 기본 -> %03x ! 자리수가 변경되는 사항(x: 소문자, X: 대문자)
	//sha-1: 16진수 40자로 생성되는 암호화 기술(%01x, %o2x)
	//sha-2: sha-222, sha-25, sha-384, sha-512
	//sha-3 sha3-222, sha3-25, sha3-384, sha3-512
	
	//복합 암호화 기술 -> base64 -> MD5 
	//복합 암호화 기술 -> md5 + sha-2
	public String md5_encode(String word) {
		
		String security = "";
		try {
			//MessageDigest: 해당 암호화 클래스 구성 형태를 가지고 있는 라이브러리 
			MessageDigest md = MessageDigest.getInstance("MD5");
			//MessageDigest md = MessageDigest.getInstance("sha-1");
			md.update(word.getBytes()); //해당 암호화 기준으로 byte문자를 변환
			byte md5byte[] = md.digest(); //암호화된 바이트를 원시배열에 저장
			
			StringBuilder sb = new StringBuilder(); //문자열 클래스로 
			for(byte s : md5byte) { //forEach문
				sb.append(String.format("%02x", s)); //%02x: 2자리 문자 
				//%02x: 2자리 문자 -> 1234 -> 01, 02, 03, 04
				//%01x: 1자리 문자 -> 1234 -> 1, 2, 3, 4
			}
			security = String.valueOf(sb);
		}
		catch(Exception e) { //암호화 문제 발생
			security = "MD5 Error!!"; 
		}
		return security;
	}
}
