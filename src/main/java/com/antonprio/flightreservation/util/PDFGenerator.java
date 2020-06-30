package com.antonprio.flightreservation.util;

import com.antonprio.flightreservation.entities.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

    public void generateItinerary(Reservation reservation, String filePath) {
        LOGGER.info("generateItinerary()");

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            LOGGER.error("Exception in method generateItinerary" + e);
        }
    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Flight Itinarery"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Airline");
        table.addCell(reservation.getFlight().getOperatingAirlines());

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());

        table.addCell("Date of Departure");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());

        table.addCell("Estimated Departure Time");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        cell = new PdfPCell(new Phrase("Passanger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Passanger Name");
        table.addCell(reservation.getPassanger().getFirstName() + ' ' + reservation.getPassanger().getMiddleName() + ' ' + reservation.getPassanger().getLastName());

        table.addCell("Email");
        table.addCell(reservation.getPassanger().getEmail());

        table.addCell("Phone Number");
        table.addCell(reservation.getPassanger().getPhone());

        return table;
    }
}
