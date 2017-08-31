package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import static java.lang.Math.max;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        //dist entre os centros de c1 e c2 <= raio de c1+raio c2
        Vector2 vc1 = new Vector2(c1.x,c1.y);
        Vector2 vc2 = new Vector2(c2.x,c2.y);
        float som = c1.radius+c2.radius;
        if(vc1.dst2(vc2)<=(som*som))
            return true;
        return false;
    }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param a
     * @param b
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean lineOverlap(float aMax, float  aMin, float bMax, float  bMin){
        //vector2 x=max y=min
        if(aMin<bMin && bMin<=aMax)
            return true;
        return bMin<aMin && aMin<=bMax;
    }
    
    /*
    public static final boolean lineOverlap(float aMin, float aMax, float bMin, float bMax){
        return aMax >= bMin && aMin <= bMax;
    }
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        return lineOverlap(, 0, 0, 0)
    }*/
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        if(lineOverlap(r1.x+r1.width, r1.x,r2.x+r2.width, r2.x))
            return lineOverlap(r1.y+r1.height,r1.y, r2.y+r2.height, r2.y);    
        return false;
    }
}
