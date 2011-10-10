package trotz.bootstrap;

import java.io.InputStream;

import taco.VoidController;
import trotz.BlobStoreUtil;
import trotz.PortfolioSection;
import trotz.entities.PortfolioItem;

import com.google.appengine.api.blobstore.BlobKey;

public class BootstrapController extends VoidController {

	@Override
	public Void execute() {
		create(PortfolioSection.BOOKS, "landbok4_omslag1.png");
		create(PortfolioSection.BOOKS, "landbok4.png");
		create(PortfolioSection.BOOKS, "landbok4a.png");
		create(PortfolioSection.BOOKS, "landbok4b.png");
		create(PortfolioSection.BOOKS, "landbok4c.png");
		create(PortfolioSection.BOOKS, "landbok4d.png");
		create(PortfolioSection.BOOKS, "landbok4e.png");
		create(PortfolioSection.BOOKS, "landbok4_b.png");
		create(PortfolioSection.BOOKS, "landbok5_omslag1.png");
		create(PortfolioSection.BOOKS, "landbok5_b.png");
		create(PortfolioSection.BOOKS, "landbok5a.png");
		create(PortfolioSection.BOOKS, "landbok5b.png");
		create(PortfolioSection.BOOKS, "landbok5c.png");
		
		create(PortfolioSection.WEB, "evakus_webb_a.png");
		create(PortfolioSection.WEB, "evakus_webb_b.png");
		create(PortfolioSection.WEB, "jannikes_sajt_a.png");
		create(PortfolioSection.WEB, "jannikes_sajt_b.png");
		
		create(PortfolioSection.PRINT, "inbjudan1_s1.png");
		create(PortfolioSection.PRINT, "inbjudan1_s2-3.png");
		create(PortfolioSection.PRINT, "inbjudan1_s4.png");
		
		
		create(PortfolioSection.MAGAZINES, "kattis1a.png");
		create(PortfolioSection.MAGAZINES, "kattis1b.png");
		create(PortfolioSection.MAGAZINES, "kattis1c.png");
		create(PortfolioSection.MAGAZINES, "kattis1d.png");
		
		create(PortfolioSection.MAGAZINES, "kattis2a.png");
		create(PortfolioSection.MAGAZINES, "kattis2b.png");
		create(PortfolioSection.MAGAZINES, "kattis2c.png");
		create(PortfolioSection.MAGAZINES, "kattis2d.png");
		
		create(PortfolioSection.MAGAZINES, "kattis3.png");
		create(PortfolioSection.MAGAZINES, "kattis3a.png");
		create(PortfolioSection.MAGAZINES, "kattis3b.png");
		create(PortfolioSection.MAGAZINES, "kattis3c.png");
		create(PortfolioSection.MAGAZINES, "kattis3d.png");
		
		return null;
	}

	private void create(PortfolioSection section, String filename) {
		PortfolioItem item = PortfolioItem.all().filter("name", filename).get();
		if (item == null) {
			item = new PortfolioItem();
		}
		item.setDescription("Lorem ipsum");
		item.setName(filename);
		item.setSection(section);
		item.setWeight(100);
		InputStream stream = getClass().getResourceAsStream(filename);
		BlobKey key = BlobStoreUtil.createBlobFromInputStream(stream, "image/png");
		item.setImage("/blobstore/image?key=" + key.getKeyString());
		item.save();
	}
	
}
