import greenfoot.*;

public class Ladybugs extends Actor 
{
    public void act()
    {
        move(1);
        if (Greenfoot.getRandomNumber(10) < 1)
        {
            int randomAngle = Greenfoot.getRandomNumber(91) - 45;
            setRotation(getRotation() + randomAngle);
        }
        
        // Memeriksa apakah Ladybugs mencapai batas-batas yang diinginkan
        checkBounds();
        
        // Memeriksa apakah ada Cactus di depan Ladybugs
        checkForCactus();
    }
    
    // Memeriksa batasan dan menghindarinya
    private void checkBounds()
    {
        int x = getX();
        int y = getY();
        
        // Batas-batas yang diinginkan
        int minX = 25; // Batas kiri (600 - 550)
        int maxX = getWorld().getWidth() - 25; // Batas kanan (600 - 25)
        int minY = 25; // Batas atas (400 - 350)
        int maxY = getWorld().getHeight() - 25; // Batas bawah (400 - 25)
        
        if (x <= minX || x >= maxX || y <= minY || y >= maxY)
        {
            // Jika Ladybugs mencapai batasan, maka balik arah dengan tambahan random
            setRotation(getRotation() + 180 + Greenfoot.getRandomNumber(90) - 45);
        }
    }
    
    // Memeriksa apakah ada Cactus di depan Ladybugs
    private void checkForCactus()
    {
        Actor cactus = getOneObjectAtOffset(0, 0, Cactus.class); // Mengecek apakah ada Cactus di lokasi yang sama dengan Ladybugs
        if (cactus != null)
        {
            // Jika ada Cactus di depan Ladybugs, maka putar arahnya
            setRotation(getRotation() + 180 + Greenfoot.getRandomNumber(90) - 45);
        }
    }
}
