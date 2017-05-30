@EventHandler
	public void entrando(PlayerJoinEvent e){
		
		HoverMSG msg = new HoverMSG();
		msg.addText("§3Hola si necesitas ayuda ");
		msg.addHover("§4click aca", "§1justo aqui\nxD");
		msg.addText(" §6Gracias por entrar ");
		msg.addHover("§7 Diviertete ", "§bxD");
		msg.addHoverCommand("§4Ejecuta Comando", "§1Click Aqui\nPara ejecutar\nComando", "/help");
		msg.ready();
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw "+e.getPlayer().getName()+" "+msg.getMessage());
		
	}
