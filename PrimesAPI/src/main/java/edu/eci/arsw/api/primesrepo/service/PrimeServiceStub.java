package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service("primeServicesStub")
public class PrimeServiceStub implements PrimeService{
	
	List<FoundPrime> primos = new ArrayList<FoundPrime>();

	public PrimeServiceStub() {
		FoundPrime primo1 = new FoundPrime("user1", "3");
        primos.add(primo1);
        FoundPrime primo2 = new FoundPrime("user", "5");
        primos.add(primo2);
        FoundPrime primo3 = new FoundPrime("user3", "7");
        primos.add(primo3);
	}

	
	@Override
	public void addFoundPrime(FoundPrime foundPrime) throws PrimeNotFoundException {
		FoundPrime p = null;
		try {
			p = getPrime(foundPrime.getPrime());
			if (!(p.getUser().equals(foundPrime.getUser()))) {
				throw new PrimeNotFoundException("error");
			}
		} catch (PrimeNotFoundException ex) {
			synchronized (primos) {
				primos.add(foundPrime);
			}
		}
	}

	@Override
    public List<FoundPrime> getFoundPrimes() {
        return primos;
    }


	@Override
    public FoundPrime getPrime(String prime) throws PrimeNotFoundException {
        for (int i = 0; i < primos.size(); i++) {
            if (primos.get(i).getPrime().equals(prime)) {
                return primos.get(i);
            }
        }
        throw new PrimeNotFoundException("error");

    }
}
