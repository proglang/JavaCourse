package lecture20150511;

public interface IMonster {
	/**
	 * attack monster with given force
	 * @param force
	 * @return true if monster survives attack
	 */
	public boolean hit(int force);
	
	/**
	 * attack monster with weapon
	 * @param weapon
	 * @return true if monster survives
	 */
	public boolean attack(IWeapon weapon);
}
