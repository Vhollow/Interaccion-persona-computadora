
package modificador.vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import modificador.modelo.FechaHoraSistema2;

/**
 *
 * @author Vicente Martinez Franco - Alberto Gil Valverde
 */
public class ControladorModificador2 {

    private VistaModificador2 mivista;
    private FechaHoraSistema2 mimodelo;

    public ControladorModificador2(VistaModificador2 v, FechaHoraSistema2 m) {

        this.mivista = v;
        this.mimodelo = m;

    }
    
    public void deshacer(){
        
        mimodelo.deshacer();
        mivista.actualizar();
    }

    public void cambiar() throws Exception {

        int año, mes, dia, hora, min;
        try {
            año = Integer.parseInt(mivista.getAño());
        } catch (Exception e) {
            throw new Exception("año incorrecto");
        }
        try {
            dia = Integer.parseInt(mivista.getDia());

        } catch (Exception e) {
            throw new Exception("dia incorrecto");
        }

        mes = mivista.getMes();
        try{
            hora = Integer.parseInt(mivista.getHora());
        }catch(Exception e){
            throw new Exception("hora incorrecta");
        }
        
        try{
            min = Integer.parseInt(mivista.getMinutos());
        }catch(Exception e){
            throw new Exception("minutos incorrectos");
        }

        mimodelo.cambio(año, mes, dia, hora, min);

        mivista.actualizar();
        

    }

    public void salir() {

        System.exit(0);
    }

}
