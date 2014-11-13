package utils;


/**
 * Classe Interna BytePage : Representa uma página de memória. Cada página cotém um vetor de bytes, de um 
   determinado tamanho. Cada página contém um apontador para o próximo nó. 
 */
 
class BytePage {
   
   public byte page[];
   public BytePage next;
   
   public BytePage(int pageSize){
   
       page = new byte[pageSize];
       next = null;
   }
   
   
   /**
    * Converte uma página em String.
    * @return Uma representação da página em String.
    */ 
   
   public String toString(){
       return BytePageList.byteArr2String(page);
   }
}

/**
 *  BytePageList : É uma lista encadeada de páginas de memória.
 *  É possivel ler qualquer byte de qualquer posição de memória. 
 *  A escrita, no entanto,  é feita de maneira sequencial. 
 *  Novas páginas de memóriasão 
 *
 */

public class BytePageList {
    
    private int pageSize;

    private BytePage head;
    private BytePage livePage;
    private int currPageIndex;
    private int wpt;            // The writer pointer
    
  
  
    /**
     *  Construtor da classe BytePageList. 
     *  @param pageSize O tamamho da paágina em Bytes. 
     */
    
    public BytePageList(int pageSize){
       this.pageSize = pageSize;
       reset();
    }
    
    /**
     *  Construtor padrão da classe BytePageList. 
     *  Constrói uma classe com tamanho de ágina 128 bytes. 
     */
    
    public BytePageList(){
       this(128);
    }
    
    /**
     *  Adiciona um byte ao final da página corrente. Se a página corrente estiver
     *  cheia, uma nova página é adicionada ao final da lista de páginas e uma
     *  e essa nova página se torna a página corrente. O byte é então escrito nessa página.
     *  @param b o byte a ser escrito. 
     */
    
    public void add(byte b){
       if((wpt / pageSize) != currPageIndex ){
          livePage.next = new BytePage(pageSize);
          livePage = livePage.next;
          currPageIndex++;
       }
       livePage.page[wpt % pageSize] = b;
       wpt++;
    }
    
    public void add(byte b[]){
    	for(int i=0; i < b.length; i++){
    		add(b[i]);    		
    	}
    }

   /**
     *  Retorna uma página de memória. Esse método é uso interno da classe.
     *  @param i O índice da página.
     *  @return Uma referência para um byte page.
     */

    private BytePage pageIndex(int i){
       BytePage p = null;
       if (i <= currPageIndex){
         for(p = head; (p!= null) && (i > 0); p = p.next){
           i--;
         }
       }
       return p;
    }
    
    /**
     *  Retorna o array de bytes de uma página da memória. 
     *  @param i O índice  da página de memória. 
     *  @return Um vetor de bytes da página de memória.
     */
    public byte[] pageAt(int i){
       return ((pageIndex(i)).page);
    }
    
    
    /**
     *  Retorna um byte de uma dada posição na lista de páginas. 
     *  @param i O índice  do byte a ser retornado. O índice deve ser informando
               considerando-se a lista de páginas de bytes 
     *  @return O byte na posiçao relativa i.
     */
    public byte at(int i){
       BytePage p = pageIndex(i/pageSize);
       return p.page[i%pageSize];  
    }
    
    
    /**
     * Reseta a lista de  páginas. Um nova página inicial é alocada, 
     * em seguida é feita a página corrente. Escritas começam a ocorrer
     * a partir da posição zero da página.
     *
     */ 
    public void reset(){
       head = new BytePage(pageSize);
       livePage = head;
       currPageIndex = 0;
       wpt = 0;
    }

   /**
     * Retorna todo o conteúdo dessa BytePageList como um único array de bytes.
     * @return Um vetor de bytes contento todos os bytes da BytePageList atual.
     */ 

    public byte[] getContent(){
        byte r[] = new byte[wpt];
        BytePage p = null;
        int d = 0;
        for(p = head; p!= null; p = p.next){
          for(int i =0; i < pageSize; i ++){
             r[d+i] = p.page[i];
          }
          d += pageSize;
        }
        return r;
    }
    
    public String toString(){
        BytePage p;
        //int i = 0;
        String s = "[]->";
        for(p = head; p != null ; p = p.next){
            s += p.toString() + "->";
        }
        s += "|||";
        return s;
    }
    
    public static String byteArr2String (byte page[]){
       String s = "[ ";
       if(page.length > 0){
            s += page[0];
            for(int i = 1; i < page.length; i++){
                s += ", " + page[i];
            }
       }
       s += "]";
       return s;
    }
    
    public static void main(String args[]){
         BytePageList p = new BytePageList(10);
         for(int i = 0; i< 30; i++ ){
            p.add((byte)i);
         }
         System.out.println(p.toString());    
         System.out.println(BytePageList.byteArr2String(p.getContent()));
    }
}
