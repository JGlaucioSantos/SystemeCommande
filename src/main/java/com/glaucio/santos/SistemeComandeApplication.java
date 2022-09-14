package com.glaucio.santos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glaucio.santos.domain.Adresse;
import com.glaucio.santos.domain.Categorie;
import com.glaucio.santos.domain.Client;
import com.glaucio.santos.domain.Demande;
import com.glaucio.santos.domain.ItenDemande;
import com.glaucio.santos.domain.Paiement;
import com.glaucio.santos.domain.PaiementAvecBoleto;
import com.glaucio.santos.domain.PaiementAvecCarte;
import com.glaucio.santos.domain.Produit;
import com.glaucio.santos.domain.Province;
import com.glaucio.santos.domain.Ville;
import com.glaucio.santos.domain.enums.StatusPaiement;
import com.glaucio.santos.domain.enums.TypeClient;
import com.glaucio.santos.repositories.AdresseRepository;
import com.glaucio.santos.repositories.CategorieRepository;
import com.glaucio.santos.repositories.ClientRepository;
import com.glaucio.santos.repositories.DemandeRepository;
import com.glaucio.santos.repositories.ItenDemandeRepository;
import com.glaucio.santos.repositories.PaiementRepository;
import com.glaucio.santos.repositories.ProduitRepository;
import com.glaucio.santos.repositories.ProvinceRepository;
import com.glaucio.santos.repositories.VilleRepository;

@SpringBootApplication
public class SistemeComandeApplication implements CommandLineRunner {
	
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private PaiementRepository paiementRepository;
	@Autowired
	private ItenDemandeRepository itenDemandeRepository;


	public static void main(String[] args) {
		SpringApplication.run(SistemeComandeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie(null, "Informatique");
		Categorie cat2 = new Categorie(null, "Bureau");
		
		Produit p1 = new Produit(null, "ordinateur", 2000.00);
		Produit p2 = new Produit(null, "imprimante", 800.00);
		Produit p3 = new Produit(null, "souris", 80.00);
		
		cat1.getProduits().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduits().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
			
		categorieRepository.saveAll(Arrays.asList(cat1, cat2));
		produitRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Province prov1 = new Province(null, "Quebec");
		Province prov2 = new Province(null, "Toronto");
		
		Ville v1 = new Ville(null, "Levis" , prov1);
		Ville v2 = new Ville(null, "Ville de Quebec", prov2);
		Ville v3 = new Ville(null, "Saint-Foy", prov2);
		
		prov1.getVilles().addAll(Arrays.asList(v1));
		prov2.getVilles().addAll(Arrays.asList(v2, v3));
		
		provinceRepository.saveAll(Arrays.asList(prov1, prov2));
		villeRepository.saveAll(Arrays.asList(v1, v2, v3));
		
		Client cli1 = new Client(null, "Jean Phillipe", "jean@hotmail.com", TypeClient.PERSONNEPHYSIQUE);
		
		cli1.getPhones().addAll(Arrays.asList("4184467873", "4184427873"));
		
		Adresse a1 = new Adresse(null, "Rue Saint Georges", "23", "apt 104", "Lévis", "123456",  cli1, v1);
		
		Adresse a2 = new Adresse(null, "Rue Église", "2", "null", "Saint-Foy", "999999", cli1, v2);
		
		cli1.getAdresses().addAll(Arrays.asList(a1, a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		adresseRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		
		Demande d1 = new Demande(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		Demande d2 = new Demande(null, sdf.parse("10/10/2017 19:35"), cli1, a2);
		
		Paiement pto1 = new PaiementAvecCarte(null, StatusPaiement.PAYE, d1, 6);
		d1.setPaiement(pto1);
		
		Paiement pto2 = new PaiementAvecBoleto(null, StatusPaiement.ENATTENDANT, d2, sdf.parse("20/10/2017 00:00"), null);
		d2.setPaiement(pto2);
		
		cli1.getDemandes().addAll(Arrays.asList(d1, d2));
		
		demandeRepository.saveAll(Arrays.asList(d1, d2));
		paiementRepository.saveAll(Arrays.asList(pto1, pto2));
		
		ItenDemande itdem1 = new ItenDemande(d1, p1, 0.00, 1, 2000.00);
		ItenDemande itdem2 = new ItenDemande(d1, p3, 0.00, 2, 80.00);
		ItenDemande itdem3 = new ItenDemande(d2, p2, 100.00, 1, 800.00);
		
		d1.getItens().addAll(Arrays.asList(itdem1, itdem2));
		d2.getItens().addAll(Arrays.asList(itdem3));
		
		p1.getItens().addAll(Arrays.asList(itdem1));
		p2.getItens().addAll(Arrays.asList(itdem3));
		p3.getItens().addAll(Arrays.asList(itdem2));
		
		itenDemandeRepository.saveAll(Arrays.asList(itdem1, itdem2, itdem3));
		
	}

}
