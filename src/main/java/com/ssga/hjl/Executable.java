package com.ssga.hjl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssga.hjl.entity.Document;
import com.ssga.hjl.entity.Fund;
import com.ssga.hjl.service.FundService;

public class Executable {
	public static ClassPathXmlApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
	}
	
	public static void main(String[] args) throws Exception {
		FundService fundService = (FundService) context.getBean("fundService");
		Fund aFund = buildFund("aaa", "PC001");
		Fund bFund = buildFund("bbb", "PC002");
		
		fundService.saveFund(aFund);
		fundService.saveFund(bFund);
		
		Fund a1 = fundService.getFundByTicker("aaa");
		System.out.println(a1);
		Fund b1 = fundService.getFundByTicker("bbb");
		System.out.println(b1);
		Fund a2 = fundService.getFundByTicker("aaa");
		System.out.println(a2);
		Fund b2 = fundService.getFundByTicker("bbb");
		System.out.println(b2);
	}
	
	public static Fund buildFund(String ticker, String pcCode) {
		Fund fund = new Fund();
		fund.setId(123456789L);
		fund.setName(ticker + " fund name");
		fund.setTickerSymbol(ticker);
		fund.setFundCode(pcCode);
		
		Document doc1 = new Document();
		doc1.setId(213456789L);
		doc1.setTitle("doc1 title for " + ticker);
		doc1.setPath("/ssgai/tools/redis/doc1.pdf");
		doc1.setPathType(Document.PathType.LOCAL);
		
		Document doc2 = new Document();
		doc2.setId(223456789L);
		doc2.setTitle("doc2 title for " + ticker);
		doc2.setPath("https://www.abc.com");
		doc2.setPathType(Document.PathType.REMOTE);
		
		Set<Document> docs = new HashSet<Document>();
		docs.add(doc1);
		docs.add(doc2);
		
		fund.setDocuments(docs);
		return fund;
	}
}
