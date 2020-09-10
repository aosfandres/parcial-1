package edu.eci.arsw.api.primesrepo.model;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
public class FoundPrime
{
    String user;

    String prime;

    public FoundPrime(String string, String string2)
    {
    	this.user=string;
    	this.prime=string2;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser( String user )
    {
        this.user = user;
    }

    public String getPrime()
    {
        return prime;
    }

    public void setPrime( String prime )
    {
        this.prime = prime;
    }
}
