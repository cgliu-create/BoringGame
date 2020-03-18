package BoringImages;

//enums     https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
public enum BoringImage {
    //list of locations
    player0("/BoringImages/Player/Player0.png"),
    player45("/BoringImages/Player/Player45.png"),
    player90("/BoringImages/Player/Player90.png"),
    player135("/BoringImages/Player/Player135.png"),
    player180("/BoringImages/Player/Player180.png"),
    player225("/BoringImages/Player/Player225.png"),
    player270("/BoringImages/Player/Player270.png"),
    player315("/BoringImages/Player/Player315.png"),
    enemy0("/BoringImages/Enemy/Enemy0.png"),
    enemy45("/BoringImages/Enemy/Enemy45.png"),
    enemy90("/BoringImages/Enemy/Enemy90.png"),
    enemy135("/BoringImages/Enemy/Enemy135.png"),
    enemy180("/BoringImages/Enemy/Enemy180.png"),
    enemy225("/BoringImages/Enemy/Enemy225.png"),
    enemy270("/BoringImages/Enemy/Enemy270.png"),
    enemy315("/BoringImages/Enemy/Enemy315.png"),
    dead0("/BoringImages/Dead/Dead0.png"),
    dead45("/BoringImages/Dead/Dead45.png"),
    dead90("/BoringImages/Dead/Dead90.png"),
    dead135("/BoringImages/Dead/Dead135.png"),
    dead180("/BoringImages/Dead/Dead180.png"),
    dead225("/BoringImages/Dead/Dead225.png"),
    dead270("/BoringImages/Dead/Dead270.png"),
    dead315("/BoringImages/Dead/Dead315.png"),
    gray("/BoringImages/Enviro/gray.png"),
    green("/BoringImages/Enviro/green.png"),
    brown("/BoringImages/Enviro/brown.png"),
    ammo("/BoringImages/Enviro/ammo.png"),
    medkit("/BoringImages/Enviro/medkit.png"),
    box("/BoringImages/Enviro/box.png"),
    crate("/BoringImages/Enviro/crate.png"),
    wall("/BoringImages/Enviro/wall.png"),
    bush("/BoringImages/Enviro/bush.png"),
    lava("/BoringImages/Enviro/lava.png"),
    water("/BoringImages/Enviro/water.png"),
    heart("/BoringImages/Signs/heart.png"),
    bullets("/BoringImages/Signs/bullets.png"),
    gold("/BoringImages/Signs/gold.png"),
    noticeDanger("/BoringImages/Signs/noticeDanger.png"),
    noticeSelect("/BoringImages/Signs/noticeSelect.png"),
    upsign("/BoringImages/Signs/upsign.png"),
    downsign("/BoringImages/Signs/downsign.png"),
    rightsign("/BoringImages/Signs/rightsign.png"),
    leftsign("/BoringImages/Signs/leftsign.png"),
    yes("/BoringImages/Signs/yes.png"),
    no("/BoringImages/Signs/no.png"),
    bomb("/BoringImages/Weapon/bomb.png"),
    bombA("/BoringImages/Weapon/Bomba.png"),
    cannonball("/BoringImages/Weapon/cannonball.png"),
    grenade("/BoringImages/Weapon/grenade.png"),
    lavaball("/BoringImages/Weapon/lavaBall.png"),
    mine("/BoringImages/Weapon/mine.png"),
    tnt("/BoringImages/Weapon/tnt.png"),
    boxTurret0("/BoringImages/Weapon/boxTurret0.png"),
    boxTurret90("/BoringImages/Weapon/boxTurret90.png"),
    boxTurret180("/BoringImages/Weapon/boxTurret180.png"),
    boxTurret270("/BoringImages/Weapon/boxTurret270.png"),
    redflag("/BoringImages/Signs/redflag.png"),
    greenflag("/BoringImages/Signs/greenflag.png"),
    whiteflag("/BoringImages/Signs/whiteflag.png");
    //location
    private String imgLoc;
    //CONSTRUCTING
    BoringImage(String loc) {imgLoc = loc;}
    //RETRIEVING LOCATIONS
    public String getImgLoc() { return imgLoc;}
}










