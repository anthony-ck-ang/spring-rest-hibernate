package com.anthonyang;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anthonyang.domain.Customer;
import com.anthonyang.domain.Transaction;
import com.anthonyang.repository.CustomerRepository;
import com.anthonyang.repository.TransactionRepository;

@SpringBootApplication
public class RestErrorHandlingApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(RestErrorHandlingApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
    	return args -> {
			
	    	Customer dv = new Customer("Daniel","Tan","danTan@gmail.com");
	    	customerRepository.save( dv );
	    	
	    	Transaction t1 = new Transaction("Men's Nike Lunarstelos Running Shoes purchase");
	    	t1.setSlug("nike-men-shoes");
	    	t1.setTeaser("Men's Nike LunarStelos Running Shoe is the definition of "
	    			+ "plush with 2 densities of soft foam underfoot to "
	    			+ "smooth out the transition. The Hot-knife cuts throughout the midsole "
	    			+ "add flexibility for equal pressure dispersal throughout your stride.");
	    	t1.setBody("SKU simple:NI126SH96DJVMY, "
	    			+ "Upper Material:Textile mesh, "
	    			+ "Inner Material:TextileSole, Material:Rubber, "
	    			+ "Colour:Black/Metallic Silver/Anthracite/White");
	    	t1.setPostedOn(new Date());
	    	t1.setCustomer(dv);
	    	transactionRepository.save(t1);
	    	
	    	Transaction t2 = new Transaction("Men's Nike Free RN Running Shoes");
	    	t2.setSlug("nike-men-shoes");
	    	t2.setTeaser("Men's Nike Free RN Running Shoe brings you miles of comfort with a breathable engineered mesh upper and a newly designed tri-star outsole pattern that adjusts to your foot's every step, delivering support and flexibility.");
	    	t2.setBody("SKU (simple):NI126SH66SWZMY, Upper Material:Textile, Inner Material:Textile, Sole Material:Rubber, Colour:Black/White/Anthracite");
	    	t2.setPostedOn(new Date());
	    	t2.setCustomer(dv);
	    	transactionRepository.save(t2);
	    	
	    	Customer cv = new Customer("Craig","shrudonu","craigSH@gmail.com");
	    	customerRepository.save( cv );
	    	
	    	Transaction t3 = new Transaction("something");
	    	t3.setSlug("something");
	    	t3.setTeaser("something");
	    	t3.setBody("something");
	    	t3.setPostedOn(new Date());
	    	t3.setCustomer(dv);
	    	transactionRepository.save(t3);
	    	
    	};
    }
    
}
