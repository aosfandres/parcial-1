package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeNotFoundException;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController

public class PrimesController
{
	@Autowired
    PrimeService primeService;

	@RequestMapping(value = "/primes", method = GET)
	public List<FoundPrime> getPrimes() {
		return primeService.getFoundPrimes();
	}
	
	//h

	@RequestMapping(path = "/primes/{primenumber}", method = GET)
	public FoundPrime getPrime(@PathVariable(name = "primenumber") String prime) {
		try {
			return primeService.getPrime(prime);
		} catch (PrimeNotFoundException ex) {
			return null;
		}
	}
	

	@RequestMapping(path = "/primes", method = POST)
	public void addFoundPrime(@RequestBody FoundPrime prime) {
		try {
			primeService.addFoundPrime(prime);
		} catch (PrimeNotFoundException ex) {
		}
	}

	// TODO implement additional methods provided by PrimeService

}
