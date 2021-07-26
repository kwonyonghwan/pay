package keyosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

 @RestController
 public class PayController {

	@Autowired
    private PayService payService;

   	/*----  GET-----PAYED 목록 요청 */
	@GetMapping("/payList")
    public Iterable<Pay> payList() throws Exception { 

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ payList start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		return  payService.payListService();       
    }//payList


   	/*----  POST-----PAYED 주문 들어옴 */
       @RequestMapping(value="/payed", method=RequestMethod.POST)
       public String Payed(@RequestBody Payed payedObj) throws Exception {
           
           System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
           System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ Payed start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
           System.out. println(" INput payedObj :  " + payedObj.toString());
           System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 
   
       return payService.savePayedService(payedObj);
   
       } //Payed

       	   	/*----  POST-----결재함*/
	@RequestMapping(value="/pay", method=RequestMethod.POST)
	public String Pay(@RequestBody Payed payedObj) throws Exception {
		
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ Pay start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out. println(" INput payedObj :  " + payedObj.toString());
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

    return payService.PayedService(payedObj);

	} //Payed
	        
	@RequestMapping(value="/payCancelled", method=RequestMethod.POST)
	public String payCancelled(@RequestBody PayCancelled payCancelledObj) throws Exception {
		
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□ payCancelled start □□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out. println(" INput payCancelledObj :  " + payCancelledObj.toString());
        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"); 

		return payService.payCanceledService(payCancelledObj);
	} 
        




    
 }
