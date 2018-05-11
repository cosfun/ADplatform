package com.adplatform.ssp;

import com.adplatform.ssp.dao.SspMapper;
import com.adplatform.ssp.pojo.Ssp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SspTests {

	@Autowired
	private SspMapper sspMapper;

	@Test
	public void contextLoads() {

	}


	@Test
	public void findSspById(){
		/*Ssp ssp=sspMapper.selectByPrimaryKey(1l);
		System.out.println(ssp.toString());*/
	}

	@Test
	public void findSspByIdAndToken(){
		//Ssp ssp=sspMapper.selectByPrimaryKey(1l,"asd");
		//Ssp ssp=sspMapper.selectByIdAndToken(1l);
		//System.out.println(ssp.toString());
	}

}
