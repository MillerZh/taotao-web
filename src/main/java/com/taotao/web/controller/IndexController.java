package com.taotao.web.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.web.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() throws ClientProtocolException, IOException {
		ModelAndView mv = new ModelAndView("index");

		// 大广告位数据
		String indexAd1 = this.indexService.queryIndexAD1();
		mv.addObject("indexAD1", indexAd1);

		// 小广告位数据
		String indexAd2 = this.indexService.queryIndexAD2();
		mv.addObject("indexAD2", indexAd2);
		return mv;
	}
}
