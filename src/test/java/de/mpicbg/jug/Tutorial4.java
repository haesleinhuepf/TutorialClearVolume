/**
 *
 */
package de.mpicbg.jug;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imagej.display.DatasetView;
import net.imagej.display.ImageDisplay;

/**
 * @author jug
 */
public class Tutorial4 {

	public static void main( final String[] args ) {
		final String filename = "XYCZ.tif";
		final URL iconURL = ClassLoader.getSystemClassLoader().getResource( filename );
		final File file = new File( iconURL.getPath() );

		final ImageJ ij = new ImageJ();
		try {
			if ( file.exists() && file.canRead() ) {
				final Dataset ds = ij.scifio().datasetIO().open( file.getAbsolutePath() );
				final ImageDisplay display = ( ImageDisplay ) ij.display().createDisplay( ds );
				final DatasetView dsv = ij.imageDisplay().getActiveDatasetView( display );
				ij.ui().showUI();

				ij.command().run(
						de.mpicbg.jug.plugins.TutorialPlugin4.class,
						true,
						"datasetView",
						dsv );
			}
		} catch ( final IOException e ) {
			e.printStackTrace();
		}
	}

}
