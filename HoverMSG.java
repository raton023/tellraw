package com.locuracraft.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
@SuppressWarnings("unchecked")
public class HoverMSG {

	
	private JSONObject json;
	private JSONArray list;
	


	/**Crea el hover msg, recuerda poner el metodo ready() <br>
	 * al terminar de agregar frases
	 * 
	 */
	public HoverMSG(){
		
		json = new JSONObject();
		json.put("text", "");
		list = new JSONArray();
	}
	
	
	/**Esto solo agrega texto a la frase,<br>esta palabra o palabras no tendran hover<br>ni ejecutaran comandos
	 * 
	 * @param message
	 */
	public void addText(String message){
		JSONObject js = new JSONObject();
		js.put("text", message);
		list.add(js);
	}

	
	/**
	 * §1 §2 §3 §4 §5 §6 §7 §8 §9 §a §b §c §d §e §f §k §l §m §n §o §r para colores etc<br>
	 * Recuerda agregar espacios en los strings<br>
	 * \n para nuevas linea en el hovermsg<br>
	 * @param message
	 * @param hovermsg
	 */
	public void addHover(String message,String hovermsg){
		JSONObject js = new JSONObject();
		JSONObject js2 = new JSONObject();
		js.put("text", message);
		js2.put("action", "show_text");
		js2.put("value", hovermsg);
		js.put("hoverEvent", js2);
		list.add(js);
	}
	
	/**
	 * Este agrega una palabra o frase sin hover que ejecuta un comando<br>
	 * el comando debe incluir la / como /help<br>
	 * 
	 * @param message el mensaje que se pondra en el chat
	 * @param command el comando a ejecutar
	 */
	public void addCommand(String message, String command){
		JSONObject js = new JSONObject();
		js.put("text", message);
		
		JSONObject c = new JSONObject();
		c.put("action", "run_command");
		c.put("value", command);
		js.put("clickEvent", c);
		list.add(js);
	}
	
	
	/**
	 * Este agrega una palabra o frase que tiene hover y ejecuta un comando<br>
	 * 
	 * @param message la palabra o frase que se pondra en el chat
	 * @param hovermsg el texto que se pondra en el hover usar \n para nueva linea y §1... para colores y formato
	 * @param command el comando que se ejecutara ejemplo /help
	 */
	public void addHoverCommand(String message, String hovermsg, String command){
		JSONObject js = new JSONObject();
		JSONObject jsh = new JSONObject();
		js.put("text", message);
		jsh.put("action", "show_text");
		jsh.put("value", hovermsg);
		js.put("hoverEvent", jsh);
		
		JSONObject c = new JSONObject();
		c.put("action", "run_command");
		c.put("value", command);
		js.put("clickEvent", c);
		list.add(js);
		
	}
	

	
	/**
	 * al terminar de agregar palabras a la frase usar este metodo<br>para crear el JSON
	 */
	public void ready(){
		json.put("extra", list);
	}
	
	/**Regresa un String con el valor del JSON que se puede enviar a un jugador<br>
	 * por ejemplo con bukkit.dispatchCommand(bukkit.getConsoleSender(),"tellraw "+e.getPlayer().getName()+" "+msg.getMessage());
	 * 
	 * @return
	 */
	public String getMessage(){
		
		return json.toJSONString();
	}
	
		
	
}
