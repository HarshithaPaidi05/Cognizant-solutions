public class FactoryMethodExample{
    interface Document{
        void open();
    }
    static class wordDocument implements Document{
        public void open(){
            System.out.println("Word opened");
        }
    }
    static class pdfDocument implements Document{
        public void open(){
            System.out.println("pdf opened");
        }
    }
    static class ExcelDocument implements Document{
        public void open(){
            System.out.println("Excel opened");
        }
    }
    abstract static class DocumentFactory{
        public abstract Document createDocument();
    }
    static class WordFactory extends DocumentFactory{
        public Document createDocument(){
            return new wordDocument();
        }
    }
    static class PdfFactory extends DocumentFactory{
        public Document createDocument(){
            return new pdfDocument();
        }
    }
    static class ExcelFactory extends DocumentFactory{
        public Document createDocument(){
            return new ExcelDocument();
        }
    }
    
     public static void main(String[] args) {

        
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

      
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        
        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
 }
    