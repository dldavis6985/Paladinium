package paladinium.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import java.util.Random;


public class PaladinSword extends ItemSword{

	private int damageIncreaser = 0;
	private int lsDivisor = 4;
	private int dmgDivisor = 2;
	private int multiplier = -5;
	
	private int critChance;
	private int baseDamage;
	private boolean damageScales;
	private boolean crit = false;
	private boolean lifesteals;
	
	
	public PaladinSword(int par1, EnumToolMaterial par2EnumToolMaterial, int index, int cc, boolean ls, int damage, boolean dScale) {
		super(par1, par2EnumToolMaterial);
		this.setIconIndex(index);
		critChance = cc;
		lifesteals = ls;
		baseDamage = damage;
		damageScales = dScale;
	}
	
	@Override
	public String getTextureFile()
    {
            return "/PaladiniumTextures.png";
    }
	
	
	@Override
	public boolean hitEntity(ItemStack sword, EntityLiving targetCreature, EntityLiving player)
    {
		
		Random r = new Random();
		
		if(crit){
			crit = false;
		}
		
		if(r.nextInt(100) < critChance ){
			crit = true;
		}
		
		if(damageScales){
			damageIncreaser = ((EntityPlayer)player).experienceLevel/dmgDivisor;
		}
		
        
		if(lifesteals){
			healPlayer(sword, targetCreature, player);
		}
		
		super.hitEntity(sword, targetCreature, player);
		
        return true;
        
    }
	
	private void healPlayer(ItemStack sword ,EntityLiving targetCreature, EntityLiving player){
		int pHealth = player.getHealth();
		int maxHealth = player.getMaxHealth();
		int difference = maxHealth - pHealth;
		int healAmount = this.getDamageVsEntity(targetCreature)/lsDivisor;
		int repairAmount =  multiplier*(healAmount - difference);
		Random randy = new Random();
		float pitch = 0.8f + (randy.nextFloat()*0.2f);
		
		
		if(healAmount > difference){
			sword.damageItem(repairAmount, player);
			if(sword.getItemDamage() < 0) {
				sword.setItemDamage(0);
			}
		}
		
		player.worldObj.playSoundAtEntity(player, "life_steal", 1.0f, pitch );
		player.heal(healAmount);
	}
	
	@Override
	
	public int getDamageVsEntity(Entity par1SomeEntity){
		int damage = baseDamage + damageIncreaser;
		Random rand = new Random();
		
		if (crit){
			float pitch = 0.8f + (rand.nextFloat()*0.2f);
			par1SomeEntity.worldObj.playSoundAtEntity(par1SomeEntity, "crit", 1.0f, pitch );
			damage *= 10;
		}
		return damage;
	}
}
