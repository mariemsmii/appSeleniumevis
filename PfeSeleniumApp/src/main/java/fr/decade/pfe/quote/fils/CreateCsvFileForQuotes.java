package fr.decade.pfe.quote.fils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import fr.decade.pfe.sftp.connection.impl.SftpConnectionImpl;

public class CreateCsvFileForQuotes {
	
	SftpConnectionImpl sftpConnection = new SftpConnectionImpl();
	
	String username = "erptohost";
	String password = "erptohost";
	String remoteHost ="127.0.0.1";
	int remotePort = 10022 ;
	int  sessionTimeout = 100000;
	int channelTimeout = 500000;
	String regularFileNameExpression ="CsvQuote";
	String csvLocalFileQuote ="/home/mariem/Bureau/quotes/CsvQuote.csv";
	String remoteFile ="usersQuotes/quotes/CsvQuote.csv";
	String remoteFileProducts ="usersQuotes/products/CsvProductsQuote.csv";
	boolean result ;
	boolean isUploaded ;
	String createdSuccessQuotesPath ="/home/mariem/Bureau/quotes/3CsvQuote.csv";
	String createdSuccessQuotesPathProducts ="/home/mariem/Bureau/quotes/products/CsvProductsQuote.csv";
	
	
	public  boolean  createQuoteCsvFile () {
			
			
	    	final File createdSuccessQuotes = new File(createdSuccessQuotesPath);
	    	try
			{
				final FileWriter outputSuccessfile = new FileWriter(createdSuccessQuotesPath);

				final CSVWriter writerSuccessfile = new CSVWriter(outputSuccessfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

				final List<String[]> successQuotes = new ArrayList<String[]>();
				successQuotes.add(new String[]
						{ "UserId", "QuoteId", "version", "currency", "QuoteName", "Description", "CreationDate", "state", "totalPrice" });
				successQuotes.add(new String[]
						{ "william.hunter@rustic-hw.com", "21300000", "1", "USD", "Quote 21300000", "", "18.04.2022 09:42:50",
						"CREATED", "200000" });
				successQuotes.add(new String[]
						{ "william.hunter@rustic-hw.com", "23100000", "1", "USD", "Quote 23100000", "", "18.04.2022 09:42:50",
						"SELLERAPPROVER_APPROVED", "204000" });
				successQuotes.add(new String[]
						{ "william.hunter@rustic-hw.com", "13200000", "1", "USD", "Quote 13200000", "", "18.04.2022 09:42:50",
								"SELLERAPPROVER_REJECTED", "200000" });
				successQuotes.add(new String[]
						{ "william.hunter@rustic-hw.com", "21310000", "1", "USD", "Quote 21310000", "", "18.04.2022 09:42:50",
								"CREATED", "25800" });
				successQuotes.add(new String[]
						{ "william.hunter@rustic-hw.com", "23150000", "1", "USD", "Quote 23150000", "", "18.04.2022 09:42:50",
								"SELLERAPPROVER_APPROVED", "209000" });
				
				writerSuccessfile.writeAll(successQuotes);

				writerSuccessfile.close();
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}
	    	isUploaded = sftpConnection.upload(createdSuccessQuotesPath, remoteFile, username, password, remoteHost, remotePort, sessionTimeout, channelTimeout);
	    	if (isUploaded == false )
	    	{
	    		System.out.println("failed to upload file for the Quote ");
	    	}
			return result;
		}
		
		public  boolean createEntriesCsvFile() {
			
	    	final File createdSuccessQuotes = new File(createdSuccessQuotesPathProducts);
	    	try
			{
				final FileWriter outputSuccessfile = new FileWriter(createdSuccessQuotesPathProducts);

				final CSVWriter writerSuccessfile = new CSVWriter(outputSuccessfile, ';', CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
				final List<String[]> successQuotes = new ArrayList<String[]>();
				successQuotes.add(new String[]
						{ "codeQuote", "version", "productCode", "quantity", "unit", "baseprice","totalPrice" });
				successQuotes.add(new String[]
						{ "21300000", "1", "3592865", "99", "pieces", "81", "2025.0"});
				successQuotes.add(new String[]
						{ "23100000", "1", "3756505", "59", "pieces", "70", "2025.0"});
				successQuotes.add(new String[]
						{ "23100000", "1", "3592865", "99", "pieces", "50", "2584.0"});
				successQuotes.add(new String[]
						{ "23100000", "1", "3756505", "79", "pieces", "149", "2584.0"});
				successQuotes.add(new String[]
						{ "21310000", "1", "3756505", "99", "pieces", "150", "2584.0"});
				successQuotes.add(new String[]
						{ "23150000", "1", "3756505", "89", "pieces", "150", "2584.0"});
				successQuotes.add(new String[]
						{ "23150000", "1", "3592865", "89", "pieces", "120", "2584.0"});
				writerSuccessfile.writeAll(successQuotes);

				writerSuccessfile.close();
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}
	    	isUploaded = sftpConnection.upload(createdSuccessQuotesPathProducts, remoteFileProducts, username, password, remoteHost, remotePort, sessionTimeout, channelTimeout);
	    	if (isUploaded == false )
	    	{
	    		System.out.println("failed to upload file for the Products ");
	    	}
			return result;
			
		}
}
