//Widget Checker
Widget levelUp = client.getWidget(233,0);
Widget muliSkillMenu = client.getWidget(270,0);

//Saradomin Brews
int unf_potion = 3002; //change ID for other potions
int raw_item = 6693; //Change ID for other potions
int finished = 6687; // Change ID for other potions
String pot_name = "Saradomin brew(3)"; //Change string to the new 3 dose (it doesn't even matter it will still make it, but for paranoid players

//Level Up recontinue
if(levelUp != null && v.getInventory().amountInInventory(unf_potion,1,14)) {
    log.info("LEVEL UP");
    v.getInventory().useOnItem(raw_item, unf_potion);
    v.getCallbacks().afterTicks(3, () -> {
        v.invoke("Make","<col=ff9040>"+pot_name+"</col>",1,57,-1,17694734,false);
    });
}
// Potion withdrawing and maker
if(v.getInventory().amountInInventory(unf_potion,1,14) && !v.getInventory().amountInInventory(finished,1,27) && v.getLocalPlayer().hasAnimation(-1)) {
    if(v.getBank().isOpen()) {
        v.getBank().close();
    } else if(muliSkillMenu != null) { 
        v.invoke("Make","<col=ff9040>"+pot_name+"</col>",1,57,-1,17694734,false);
    } else {
        v.getInventory().useOnItem(raw_item, unf_potion);
    }
    
} else {
    if(v.getInventory().amountInInventory(finished,14,14)) {
        v.getBank().deposit(finished,14);
    } else if(!v.getInventory().amountInInventory(unf_potion,1,27)) {
        v.getBank().withdraw(unf_potion,14);
        v.getBank().withdraw(raw_item,14);
    }
}