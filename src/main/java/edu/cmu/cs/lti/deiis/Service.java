/*
 * Copyright (c) 2017. Carnegie Mellon University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package edu.cmu.cs.lti.deiis;

import org.lappsgrid.api.WebService;
import org.lappsgrid.metadata.ServiceMetadata;
import org.lappsgrid.metadata.ServiceMetadataBuilder;
import org.lappsgrid.serialization.Data;

import static org.lappsgrid.discriminator.Discriminators.*;

public class Service implements WebService
{
	private String metadata;

	public Service()
	{

	}

	@Override
	public String execute(String input)
	{
		return input;
	}

	@Override
	public String getMetadata()
	{
		if (metadata == null) {
			ServiceMetadata md = new ServiceMetadataBuilder()
					.name(this.getClass().getName())
					.version("1.0.0")
					.license(Uri.APACHE2)
					.vendor("Your name here")
					.produceFormat(Uri.LIF)
					.build();
			metadata = new Data(Uri.META, md).asPrettyJson();
		}
		return metadata;
	}
}
