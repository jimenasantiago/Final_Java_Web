package business;

import java.util.ArrayList;

import data.HealthPlanCatalog;
import entities.HealthPlan;

public class CtrlHPlan {
	public ArrayList<HealthPlan> getAllHealthPlan() {
		ArrayList<HealthPlan> hplans = new ArrayList<HealthPlan>();
		HealthPlanCatalog hplanc= new HealthPlanCatalog();
		hplans=hplanc.getAllHealthPlan();
		return hplans;
	}
	
	public HealthPlan getHealthPlan (int idHealthPlan){
		HealthPlan hp = null;
		HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
		
		hp=hplancatalog.getHPbyId(idHealthPlan);
		return hp;
		
	}	
	boolean validateHealthPlan (int idHP){
		//asks HealthPlanCatalog if the idHP belongs to a registered HP
		
		HealthPlanCatalog hplan= new HealthPlanCatalog();
		if (hplan.getHPbyId(idHP)!=null){
			return true;
		}else {
			return false;
		}	
	}
}
