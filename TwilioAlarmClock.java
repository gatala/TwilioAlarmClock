import java.util.Map;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.factory.CallFactory;


public class TwilioAlarmClock {
	
	public static void main(String[] args)  {

		if (args.length!=5) {
			System.out.println("Usage parameters: Account SID, Auth Token, From Phone Number, To Phone Number, Time (in minutes)");
			return;
		}
		
		new TwilioAlarmClock(args);
	
	}
	
	Timer timer;

	public TwilioAlarmClock(String[] args) {
	    timer = new Timer();
	    timer.schedule(new CallTask(args), Integer.parseInt(args[4])*60000);
	}

	private class CallTask extends TimerTask {
		String [] callParms = null;
		public CallTask (String[] args) {
			callParms = args;
		}
		
	    public void run() {
		    startCall(callParms);
	        timer.cancel(); 
	    }
	}
	
	private void startCall(String[] args) {
		TwilioRestClient client = new TwilioRestClient(args[0], args[1]);
		Account mainAccount = client.getAccount();
		CallFactory callFactory = mainAccount.getCallFactory();
		Map<String, String> callParams = new HashMap<String, String>();
		callParams.put("From", args[2]); // this has to be a Twilio number
		callParams.put("To", args[3]); 
		callParams.put("Url", "http://demo.twilio.com/welcome/voice/");

		// Make the call
		try {
			Call call = callFactory.create(callParams);
		} catch(Exception e)
		  {System.out.println("oops!");}
		
	}

}