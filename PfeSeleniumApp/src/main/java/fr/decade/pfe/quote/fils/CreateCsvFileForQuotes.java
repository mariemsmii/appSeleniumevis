package fr.decade.pfe.quote.fils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVWriter;

import fr.decade.pfe.sftp.connection.impl.SftpConnectionImpl;

public class CreateCsvFileForQuotes {

	SftpConnectionImpl sftpConnection = new SftpConnectionImpl();

	String username = "erptohost";
	String password = "erptohost";
	String remoteHost = "127.0.0.1";
	int remotePort = 10022;
	int sessionTimeout = 100000;
	int channelTimeout = 500000;
	String regularFileNameExpression = "CsvQuote";
	String csvLocalFileQuote = "/home/mariem/Bureau/quotes/CsvQuote.csv";
	String remoteFile = "usersQuotes/quotes/CsvQuote.csv";
	String remoteFileProducts = "usersQuotes/products/CsvProductsQuote.csv";
	boolean result;
	boolean isUploaded;
	String createdSuccessQuotesPath = "/home/mariem/Bureau/quotes/3CsvQuote.csv";
	String createdSuccessQuotesPathProducts = "/home/mariem/Bureau/quotes/products/CsvProductsQuote.csv";
	int max = 99999999;
	int min = 10000000;
	Random rnd = new Random();
	int number1 = rnd.nextInt(max - min) + min;
	int number2 = rnd.nextInt(max - min) + min;
	int number3 = rnd.nextInt(max - min) + min;
	int number4 = rnd.nextInt(max - min) + min;
	int number5 = rnd.nextInt(max - min) + min;
	int length;
	public String id1 = String.valueOf(number1);
	public String id2 = String.valueOf(number2);
	public String id3 = String.valueOf(number3);
	public String id4 = String.valueOf(number4);
	public String id5 = String.valueOf(number5);

	public boolean createQuoteCsvFile() {
		final File createdSuccessQuotes = new File(createdSuccessQuotesPath);

		try {
			final FileWriter outputSuccessfile = new FileWriter(createdSuccessQuotesPath);

			final CSVWriter writerSuccessfile = new CSVWriter(outputSuccessfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			final List<String[]> successQuotes = new ArrayList<String[]>();
			successQuotes.add(new String[] { "UserId", "QuoteId", "version", "currency", "QuoteName", "Description",
					"CreationDate", "state", "totalPrice" });
			successQuotes.add(new String[] { "william.hunter@rustic-hw.com", "26500386", "1", "USD", "Quote 21300000", "",
					"18.04.2022 09:42:50", "CREATED", "200000" });
			successQuotes.add(new String[] { "william.hunter@rustic-hw.com", "56265000", "1", "USD", "Quote 23100000", "",
					"18.04.2022 09:42:50", "SELLERAPPROVER_APPROVED", "204000" });
			successQuotes.add(new String[] { "william.hunter@rustic-hw.com", "25848361", "1", "USD", "Quote 13200000", "",
					"18.04.2022 09:42:50", "SELLERAPPROVER_REJECTED", "200000" });
			successQuotes.add(new String[] { "william.hunter@rustic-hw.com", "22933293", "1", "USD", "Quote 21310000", "",
					"18.04.2022 09:42:50", "CREATED", "25800" });
			successQuotes.add(new String[] { "william.hunter@rustic-hw.com", "79732180", "1", "USD", "Quote 23150000", "",
					"18.04.2022 09:42:50", "SELLERAPPROVER_APPROVED", "209000" });

			writerSuccessfile.writeAll(successQuotes);

			writerSuccessfile.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		isUploaded = sftpConnection.upload(createdSuccessQuotesPath, remoteFile, username, password, remoteHost,
				remotePort, sessionTimeout, channelTimeout);
		if (isUploaded == false) {
			System.out.println("failed to upload file for the Quote ");
		}
		return result;
	}

	public boolean createEntriesCsvFile() {

		final File createdSuccessQuotes = new File(createdSuccessQuotesPathProducts);
		try {
			final FileWriter outputSuccessfile = new FileWriter(createdSuccessQuotesPathProducts);

			final CSVWriter writerSuccessfile = new CSVWriter(outputSuccessfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			final List<String[]> successQuotes = new ArrayList<String[]>();
			successQuotes.add(new String[] { "codeQuote", "version", "productCode", "quantity", "unit", "baseprice",
					"totalPrice" });
			successQuotes.add(new String[] { "26500386", "1", "3592865", "99", "pieces", "81", "2025.0" });
			successQuotes.add(new String[] { "26500386", "1", "3756505", "59", "pieces", "70", "2025.0" });
			successQuotes.add(new String[] { "56265000", "1", "3592865", "99", "pieces", "50", "2584.0" });
			successQuotes.add(new String[] { "56265000", "1", "3756505", "79", "pieces", "149", "2584.0" });
			successQuotes.add(new String[] { "25848361", "1", "3756505", "99", "pieces", "150", "2584.0" });
			successQuotes.add(new String[] { "22933293", "1", "3756505", "89", "pieces", "150", "2584.0" });
			successQuotes.add(new String[] { "79732180", "1", "3592865", "89", "pieces", "120", "2584.0" });
			writerSuccessfile.writeAll(successQuotes);

			writerSuccessfile.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		isUploaded = sftpConnection.upload(createdSuccessQuotesPathProducts, remoteFileProducts, username, password,
				remoteHost, remotePort, sessionTimeout, channelTimeout);
		if (isUploaded == false) {
			System.out.println("failed to upload file for the Products ");
		}
		return result;

	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public String getId4() {
		return id4;
	}

	public void setId4(String id4) {
		this.id4 = id4;
	}

	public String getId5() {
		return id5;
	}

	public void setId5(String id5) {
		this.id5 = id5;
	}
}
