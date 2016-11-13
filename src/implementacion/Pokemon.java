package implementacion;

public class Pokemon {
	
	/*Atributos*/
	private String nombre;
	private long puntosDeCombate;
	private long puntosDeSalud;
	private Tipo tipo;
	private int  ataque;
	private int defensa;
	private int stamina;
	
	public Pokemon(String nombre, long puntosDeCombate, long puntosDeSalud,
			Tipo tipo, int ataque, int defensa, int stamina) {
		super();
		this.nombre = nombre;
		this.puntosDeCombate = puntosDeCombate;
		this.puntosDeSalud = puntosDeSalud;
		this.tipo = tipo;
		this.ataque = ataque;
		this.defensa = defensa;
		this.stamina = stamina;
	}	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getPuntosDeCombate() {
		return this.puntosDeCombate;
	}
	
	public void setPuntosDeCombate(long puntosDeCombate) {
		this.puntosDeCombate = puntosDeCombate;
	}
	
	public long getPuntosDeSalud() {
		return this.puntosDeSalud;
	}
	
	public void setPuntosDeSalud(long puntosDeSalud) {
		this.puntosDeSalud = puntosDeSalud;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getDefensa() {
		return this.defensa;
	}
	
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public int getStamina() {
		return this.stamina;
	}
	
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
}
