package goep.hm.spc.controller;

import goep.hm.spc.model.SpcInput;
import goep.hm.spc.model.SpcResult;
import goep.hm.spc.service.ISPCService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller Class for SPC
 */
@Controller
@RequestMapping(value = "/")
public class SPCController {

	@Resource(name = "spcService")
	private ISPCService spcService;

	@RequestMapping(path = "/index", method = { RequestMethod.GET })
	public String index(final RedirectAttributes redirectModel, final Model model) {
		model.addAttribute("spcInput", new SpcInput());
		List<SpcResult> list = spcService.listResult();
		// Get all list from Service and display in jsp
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(path = "/result", method = { RequestMethod.POST })
	public String result(SpcInput spcInput, Model model) {
		spcService.sort(spcInput);
		List<SpcResult> list = spcService.listResult();
		// Get all list from Service and display in jsp
		model.addAttribute("list", list);
		return "result";
	}
}
