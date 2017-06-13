/**
 *
 */
package de.mpicbg.jug.tutorials;

import javax.swing.JFrame;

import org.scijava.Context;
import org.scijava.app.StatusService;
import org.scijava.io.IOService;
import org.scijava.log.LogService;

import ij.IJ;
import ij.ImageJ;
import io.scif.codec.CodecService;
import io.scif.formats.qt.QTJavaService;
import io.scif.formats.tiff.TiffService;
import io.scif.img.ImgUtilityService;
import io.scif.services.DatasetIOService;
import io.scif.services.FormatService;
import io.scif.services.JAIIIOService;
import io.scif.services.LocationService;
import io.scif.services.TranslatorService;
import net.imagej.DatasetService;
import net.imagej.ops.OpMatchingService;
import net.imagej.ops.OpService;

/**
 * @author jug
 */
public class Tutorial1 {

	public static boolean isStandalone = true;
	private static OpService ops;
	private static Object segPlugins;

	/**
	 * @param args
	 */
	public static void main( final String[] args ) {
		System.setProperty( "apple.laf.useScreenMenuBar", "true" );

		if ( isStandalone ) { // main NOT called via Tr2dPlugin
			final ImageJ temp = IJ.getInstance();
			if ( temp == null ) {
				new ImageJ();
			}

			final Context context =
					new Context( FormatService.class, OpService.class, OpMatchingService.class, IOService.class, DatasetIOService.class, LocationService.class, DatasetService.class, ImgUtilityService.class, StatusService.class, TranslatorService.class, QTJavaService.class, TiffService.class, CodecService.class, JAIIIOService.class, LogService.class );
			ops = context.getService( OpService.class );
		}

		final JFrame guiFrame = new JFrame( "ClearVolume Tutorial 1" );
	}

}
