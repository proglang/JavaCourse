package decorator;

public interface IMonsterInternal extends IMonster {
	boolean hit(int force, IMonster target);
}
