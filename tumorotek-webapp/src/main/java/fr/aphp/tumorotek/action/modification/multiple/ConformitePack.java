/** 
 * Copyright ou © ou Copr. Ministère de la santé, FRANCE (01/01/2011)
 * dsi-projet.tk@aphp.fr
 * 
 * Ce logiciel est un programme informatique servant à la gestion de 
 * l'activité de biobanques. 
 *
 * Ce logiciel est régi par la licence CeCILL soumise au droit français
 * et respectant les principes de diffusion des logiciels libres. Vous 
 * pouvez utiliser, modifier et/ou redistribuer ce programme sous les 
 * conditions de la licence CeCILL telle que diffusée par le CEA, le 
 * CNRS et l'INRIA sur le site "http://www.cecill.info". 
 * En contrepartie de l'accessibilité au code source et des droits de   
 * copie, de modification et de redistribution accordés par cette 
 * licence, il n'est offert aux utilisateurs qu'une garantie limitée. 
 * Pour les mêmes raisons, seule une responsabilité restreinte pèse sur 
 * l'auteur du programme, le titulaire des droits patrimoniaux et les 
 * concédants successifs.
 *
 * A cet égard  l'attention de l'utilisateur est attirée sur les 
 * risques associés au chargement,  à l'utilisation,  à la modification 
 * et/ou au  développement et à la reproduction du logiciel par 
 * l'utilisateur étant donné sa spécificité de logiciel libre, qui peut 
 * le rendre complexe à manipuler et qui le réserve donc à des 	
 * développeurs et des professionnels  avertis possédant  des 
 * connaissances  informatiques approfondies.  Les utilisateurs sont 
 * donc invités à charger  et  tester  l'adéquation  du logiciel à leurs
 * besoins dans des conditions permettant d'assurer la sécurité de leurs
 * systèmes et ou de leurs données et, plus généralement, à l'utiliser 
 * et l'exploiter dans les mêmes conditions de sécurité. 
 *	
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous 
 * avez pris connaissance de la licence CeCILL, et que vous en avez 
 * accepté les termes. 
 **/
package fr.aphp.tumorotek.action.modification.multiple;

import java.util.ArrayList;
import java.util.List;

import fr.aphp.tumorotek.model.qualite.NonConformite;

/**
 * Classe de transport contenant une non conformité, cad 
 * si l'objet est conforme (booleen true/false) et le cas 
 * échéant la raison de la non conformité. 
 * Date: 22/09/2012.
 * 
 * @author Mathieu BARTHELEMY
 * @version 2.0.8
 *
 */
public class ConformitePack {

// private static final long serialVersionUID = 3551763682958457361L;
	
	private Boolean nonConforme;
	private List<NonConformite> nonConformites = new ArrayList<NonConformite>();

	public Boolean getNonConforme() {
		return nonConforme;
	}
	
	public void setConforme(Boolean c) {
		if (c != null) {
			nonConforme = !c;
		} else {
			nonConforme = null;
		}
	}
	
	public Boolean getConforme() {
		if (nonConforme != null) {
			return !nonConforme;
		} 
		return null;
	}

	public void setNonConforme(Boolean nc) {
		this.nonConforme = nc;
	}

	public List<NonConformite> getNonConformites() {
		return nonConformites;
	}

	public void setNonConformites(List<NonConformite> nce) {
		this.nonConformites = nce;
	}
	
	public boolean isEmpty() {
		return nonConforme == null 
			&& (nonConformites == null || nonConformites.isEmpty());
	}
	
	@Override
	public boolean equals(Object obj) {
			
		if (this == obj) {
			return true;
		}

		if ((obj == null) || !(obj instanceof ConformitePack)) {
			return false;
		}
		ConformitePack test = (ConformitePack) obj;
		return ((this.nonConformites == test.nonConformites
				|| (this.nonConformites != null 
						&& this.nonConformites.equals(test.nonConformites)))
				&& (this.nonConforme == test.nonConforme
						|| (this.nonConforme != null 
						&& this.nonConforme.equals(test.nonConforme)))
				);
	}
	
	@Override
	public int hashCode() {
		
		int hash = 7;
		int hashNonConforme = 0;
		int hashNonConformites = 0;
		
		if (this.nonConforme != null) {
			hashNonConforme = this.nonConforme.hashCode();
		}
		if (this.nonConformites != null) {
			hashNonConformites = this.nonConformites.hashCode();
		}
		
		hash = 31 * hash + hashNonConforme;
		hash = 31 * hash + hashNonConformites;
		
		return hash;
	}
	
	public ConformitePack clone() {
		ConformitePack clone = new ConformitePack();
		
		if (getNonConforme() != null) {
			clone.setNonConforme(getNonConforme());
		}
		
		if (getNonConformites() != null) {
			clone.getNonConformites().addAll(getNonConformites());
		}
		return clone;
	}
}