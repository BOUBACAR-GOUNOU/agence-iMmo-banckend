package com.immobilier.agence;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class AgenceImmoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgenceImmoApplication.class, args);
	}
	
	
//	@Autowired
//	private ClientRepository clientRepository;
//	
	
//	@Autowired
//	private BienRepository bienRepository;
//	
//	@Autowired
//	private CategorieRepository categorieRepository;

	
	@Override
	public void run (String... args) throws Exception
	{    
	
//		Categorie categorie1 = new Categorie("Parcelle");
//		categorieRepository.save(categorie1);
		
//		Categorie categorie2 = new Categorie("Maison meublé");
//		categorieRepository.save(categorie2);
		
//		Bien bien1 =  new Bien("Terrain 25 mètre carrée", "9",458404487, 1, "COTONOU", StatutBien.LOCATION);
//		bienRepository.save(bien1);

//		Bien bien2 =  new Bien("Parcelle de 200 mètre carrée", "https://dummyimage.com/450x300/dee2e6/6c757d.jpg",458404487, 1, "COTONOU", StatutBien.VENTE);
//		List<Categorie> categorie = categorieRepository.findByName("Parcelle");
         
//		bien2.setCategorie(categorie2);
//		bienRepository.save(bien2);
//		
//		
//	   
		

		System.out.println( " Prêt");
	
	}

}
