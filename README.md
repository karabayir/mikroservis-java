# mikroservis-java

### Bu proje bir @folksdev projesidir. 

 Orjinal projede kotlin kullanılırken bu projede kotlin yerine lombok ve dto converter'lar kullanıldı.
 
 
 ### Eureka Ne İş Yapar ?
 Mevcut durumda BookService LibraryService varlığından , LibraryService ise BookService varlığından habersiz.İkisi de bambaşka yerlerde çalışıyorlar.
 Bunların birbirlerinin varlığından haberdar olmasını sağlayan Eureka Server dır.
 
 Bütün mikroservisleri Eureka ya kaydetmek zorunda değiliz.Bir mikroservis verisini başka bir yere gönderecekse Eureka ya kayıt edilmelidir.
 LibraryService kitap bilgilerini almak için BookService bigisine ihtiyacı var. Ancak BookService in LibraryService e yönelik herhangi bir bilgi isteme durumu
 bulunmadığı için Eureka ya sadece BookService kayıt edildi. LibraryService Eureka dan BookService bilgisini isteyerek kitap bilgisine artık ulaşabilir.
 BookService RestApi kullandığı için iletişim Http üzerinden Rest Call kullanrak gerçekleşir. Grpc olsaydı grpc protokolü şekilde gerçekleşecekti.Soap olsaydı xml 
 şeklide olacaktı.
 
 ### RestApi İle İletişim
 
 1-) Rest Template
 
 Rest Template ile sorgu hazırlanıp gelen json cevabını object mapper yardımıyla istenilen objeye çevirerek istenilen yerde kullanılabilir.
 
 2-) Feign Client
 
  Rest Template ile sorgu hazırlanıp gelen json cevabını object mapper kullanımına gerek bırakmadan otomatik olarak istenilen objeye dönüştürür.
  Ayrıca hata ayıklama senaryolarında da kolaylıklar sağlar.
 
 
 
 
![mikroservis](https://user-images.githubusercontent.com/101670417/196227595-ce0cb256-bc41-41a2-b111-a5212b9bac0a.jpg)

