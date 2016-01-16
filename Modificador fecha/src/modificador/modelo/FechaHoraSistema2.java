
package modificador.modelo;


/**
 *
 * @author Vicente Martinez Franco - Alberto Gil Valverde
 */
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class FechaHoraSistema2 {
    private GregorianCalendar fechaHora_actual;
    private GregorianCalendar fechaHora_anterior;
    private ArrayList <GregorianCalendar> historial;
    
    public FechaHoraSistema2(){
        fechaHora_actual=(GregorianCalendar)GregorianCalendar.getInstance();
        historial=new ArrayList <GregorianCalendar>();
    }

    /**
     * 
     * 
     * @param dia dia de la fecha
     * @param mes mes de la fecha
     * @param año año de la fecha
     * 
     * @return devuelbe true si es correcta la fecha
     */
    private boolean fechaCorrecta(int dia,int mes,int año){
        //Mira que la convinacion de dia mes y año sea posible.Las excepciones mejor hacerlas saltar en los metodos correspondientes.
        if​(año<fechaHora_actual.getActualMinimum(GregorianCalendar.YEAR)){
            //Excepcion año incorrecto
            return false;
        }
        else{
            switch(mes){
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    if(dia>0 && dia<32) return true;
                    else return false;//Excepcion dia incorrecto
                case 3:
                case 5:
                case 8:
                case 10:
                    if(dia>0 && dia<31) return true;
                    else return false;//Excepcion dia incorrecto
                case 1:
                    if(año%4==0 && año%100!=0){
                        if(dia>0 && dia<30) return true;
                        else return false;//Excepion dia incorrecto
                    }
                    else{
                        if(dia>0 && dia<29) return true;
                        else return false;//Excepcion dia incorrecto
                    }
                default: return false;//Excepcion mes incorrecto 
            }
        }
    }
    /**
     * 
     * cambia la fecha y la hora actual
     * 
     * @param año año de la nueva fecha
     * @param mes mes de la nueva fecha
     * @param dia dia de la nueva fecha
     * @param hora hora de la nueva fecha
     * @param min minutos de la nueva fecha
     * 
     * @throws Exception si no pueda cambiar la fecha porque algun parametro es incorrecto o esta fuera de rango lanza una excepcion de tippo Exception
     */
    public void cambio(int año, int mes, int dia, int hora, int min) throws Exception{
        fechaHora_anterior=new GregorianCalendar();

        if(fechaCorrecta(dia,mes,año)){
            
            int año1, mes1, dia1, hora1, min1;
            
            año1 = fechaHora_actual.get(GregorianCalendar.YEAR);
            mes1 = fechaHora_actual.get(GregorianCalendar.MONTH);
            dia1 = fechaHora_actual.get(GregorianCalendar.DATE);
            hora1 = fechaHora_actual.get(GregorianCalendar.HOUR);
            min1 = fechaHora_actual.get(GregorianCalendar.MINUTE);
            
            if(fechaHora_anterior!=null){
                historial.add(fechaHora_anterior);
            }
            
            //ponemos la fecha anterior con lo que habia en la fecha actual
            fechaHora_anterior.set(GregorianCalendar.YEAR, año1);
            fechaHora_anterior.set(GregorianCalendar.MONTH, mes1);
            fechaHora_anterior.set(GregorianCalendar.DATE, dia1);
            fechaHora_anterior.set(GregorianCalendar.HOUR, hora1);
            fechaHora_anterior.set(GregorianCalendar.MINUTE, min1);
            
            
            if(hora>23){
                throw new Exception("hora incorrecta");
            }
            fechaHora_actual.set(GregorianCalendar.HOUR, hora);

            if(min>59){
                throw new Exception("minutos incorrectos");
            }
            fechaHora_actual.set(GregorianCalendar.YEAR, año);
            fechaHora_actual.set(GregorianCalendar.MONTH, mes);
            fechaHora_actual.set(GregorianCalendar.DATE, dia);
            
            
            
            

        
        fechaHora_actual.set(GregorianCalendar.MINUTE, min);
            
        }else{
            if(año<1){
                
                throw new Exception("año incorrecto");//Excepcion
            }else{
                throw new Exception("dia incorrecto");//Excepcion
            }
        }
        
    }
    
    public void deshacer(){
        
        if (fechaHora_anterior!=null){
            
            int año, mes, dia, hora, min;
        
            año = fechaHora_anterior.get(GregorianCalendar.YEAR);
            mes = fechaHora_anterior.get(GregorianCalendar.MONTH);
            dia = fechaHora_anterior.get(GregorianCalendar.DATE);
            hora = fechaHora_anterior.get(GregorianCalendar.HOUR);
            min = fechaHora_anterior.get(GregorianCalendar.MINUTE);

            //ponemos la fecha actual como fecha anterior
            fechaHora_actual.set(GregorianCalendar.YEAR, año);
            fechaHora_actual.set(GregorianCalendar.MONTH, mes);
            fechaHora_actual.set(GregorianCalendar.DATE, dia);
            fechaHora_actual.set(GregorianCalendar.HOUR, hora);
            fechaHora_actual.set(GregorianCalendar.MINUTE, min);
            
            if(!historial.isEmpty()){
                fechaHora_anterior=historial.get(0);
                historial.remove(0);
            }
            else{
                fechaHora_anterior=null;
            }
            
        }
    }
    public boolean puedeDeshacer(){
        if(fechaHora_anterior!=null) return true;
        else return false;
    }
    private GregorianCalendar getActual(){
        return fechaHora_actual;
    }
    
    public int getAño(){
        return fechaHora_actual.get(GregorianCalendar.YEAR);
    }
    
    public void setAño(int año)throws Exception{
        if(fechaCorrecta(getDia(),getMes(),año)){
            fechaHora_actual.set(GregorianCalendar.YEAR, año);
        }
        else{
            throw new Exception("año incorrecto");//Excepcion
        }
    }
    public int getMes(){
        return fechaHora_actual.get(GregorianCalendar.MONTH);
    }
    public void setMes(int mes)throws Exception{
        if(fechaCorrecta(getDia(),mes,getAño())){
            fechaHora_actual.set(GregorianCalendar.MONTH, mes);
        }
        else{
            throw new Exception("mes incorrecto");//Excepcion
        }
    }
    public int getDia(){
        return fechaHora_actual.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public void setDia(int dia) throws Exception{
        if(fechaCorrecta(dia,getMes(),getAño())){
            fechaHora_actual.set(GregorianCalendar.DAY_OF_MONTH, dia);
        }
        else{
            throw new Exception("dia incorrecto");//Excepcion
        }
    }
    
    public int getHora(){
        return fechaHora_actual.get(GregorianCalendar.HOUR);
    }
    
    public int getMinutos(){
        return fechaHora_actual.get(GregorianCalendar.MINUTE);
    }
            
    public void setHora(int hora) throws Exception{
        if(hora>23){
            throw new Exception("Hora fuera de rango");
        }
        fechaHora_actual.set(GregorianCalendar.HOUR, hora);
    }
    
    public void setMinutos(int min) throws Exception{
        if(min>59){
            throw new Exception("Minutos fuera de rango");
        }
        fechaHora_actual.set(GregorianCalendar.MINUTE, min);
    }
}