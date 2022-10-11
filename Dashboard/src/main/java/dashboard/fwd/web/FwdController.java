package dashboard.fwd.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import dashboard.fwd.domain.ClimateVO;
import dashboard.fwd.domain.ParameterList;
import dashboard.fwd.service.FwdService;


//@CrossOrigin(origins = "http://localhost:8080")
@Controller
//@RequestMapping("/detail/*")
//@RestController
public class FwdController {
	
	@Autowired
	private FwdService service;
	
	public String returnClimate() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ClimateVO vo = new ClimateVO();
		List<ClimateVO> list = service.selectTest(vo);
		/*
		for(int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
		}
		*/
		
//		model.addAttribute("list", list);
		String json = mapper.writeValueAsString(list);	
		return json;
	}
	
	/*
	public String returnGochang() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		GochangDataVO vo = new GochangDataVO();
		List<GochangDataVO> list = service.returnGochangData(vo);
		
		String json = mapper.writeValueAsString(list);	
		return json;
	}
	*/
	
	/*
	@RequestMapping(value="/{parameter}", method=RequestMethod.GET)
	@ResponseBody
	// "Dashboard/detail/{}"로 해야 됨
	// parameter는 climate, gochang
	public String returnParameter(@PathVariable("parameter") String parameter) throws Exception {  //Model model
	
		String json = "";
		System.out.println("파라미터: "+parameter);
			
		if(parameter.equals("climate")) {
			System.out.println("parameter: climate");
			json = returnClimate();
		}else if(parameter.equals("gochang")){
			System.out.println("parameter: gochang");
			json = returnGochang();
		}
		
		return json;
	}
	*/
	@RequestMapping(value="/{parameter}", method=RequestMethod.GET)
	@ResponseBody
	// "Dashboard/detail/{}"로 해야 됨
	// parameter는 climate, gochang
	// "Dashboard/detail/climate?sdate=20180101&edate=20180102
	public String queryString(@PathVariable("parameter")String parameter, @RequestParam(name="sdate") String sdate, @RequestParam(name="edate") String edate) throws Exception {  //Model model
	
		System.out.println("Start Date: " + edate);
		System.out.println("End Date: " + sdate);
//		System.out.println("파라미터: "+parameter);
		
		List<String> list = new ArrayList<>();
		list.add(sdate);
		list.add(edate);
		ParameterList param = new ParameterList(list);
		
		if(parameter.equals("climate")) {
			param.setType("tb_climate_tp");
			param.setDataName("DAILYDATADT");
		}else if(parameter.equals("gochang")) {
			param.setType("tb_gochang_data_tp");
			param.setDataName("FILE_DT");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list2 = service.returnData(param);
		
		String json = mapper.writeValueAsString(list2);	
		return json;
		/*	
		if(parameter.equals("climate")) {
			System.out.println("parameter: climate");
			json = returnClimate();
		}else if(parameter.equals("gochang")){
			System.out.println("parameter: gochang");
			json = returnGochang();
		}
		*/
		
	
		
//		return service.returnData(list);
	}
	
	/*
	@RequestMapping(value="/{parameter}", method=RequestMethod.GET)
	@ResponseBody
	public String returnData(@PathVariable("parameter") Object vo, String parameter ) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list = service.returnData(vo);
			
		for(int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
		}
		
		String json = mapper.writeValueAsString(list);	
		return json;
	}
	
	*/
	
	/*
	@RequestMapping(value="detail.do")
	public String testListDo(ClimateVO vo, Model model) throws Exception{
		model.addAttribute("list", service.selectTest(vo));
		System.out.println( "vo : " + vo.toString() );
		return "detail";
	}
	*/
	

	@RequestMapping(value="/detail.do")
	public String selectReqUrl(@ModelAttribute("searchVO") ClimateVO searchVO, ModelMap model) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		List<ClimateVO> list = service.selectTest(searchVO);
		String json = mapper.writeValueAsString(list);
		model.addAttribute("json", json); //service.selectTest(searchVO)
		return "detail";
	}
	
	
	
	@GetMapping("/main.do")
	public String mainPage() {
		return "main";
	}
	@GetMapping("/display.do")
	public String displayPage() {
		return "display";
	}
	@GetMapping("/risk.do")
	public String riskPage() {
		return "risk";
	}
	
}
