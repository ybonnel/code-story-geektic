/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter.sample;

import twitter.GeektickHashTagListener;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * <p>This is a code example of Twitter4J Streaming API - sample method support.<br>
 * Usage: java twitter4j.examples.PrintSampleStream<br>
 * </p>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class PrintSampleStream {
    /**
     * Main entry of this application.
     *
     * @param args
     */
    public static void main(String[] args) throws TwitterException {
		TwitterStream twitterStream = new TwitterStreamFactory(
				new ConfigurationBuilder()
						.setOAuthAccessToken(System.getenv("ACCESSTOKEN"))
						.setOAuthAccessTokenSecret(System.getenv("ACCESSTOKENSECRET"))
						.setOAuthConsumerKey(System.getenv("CONSUMERKEY"))
						.setOAuthConsumerSecret(System.getenv("CONSUMERSECRET"))
				.build()
		).getInstance();

        StatusListener listener = new GeektickHashTagListener();
        twitterStream.addListener(listener);
        twitterStream.filter(new FilterQuery().track(new String[] {"#geektic"}));
    }
}