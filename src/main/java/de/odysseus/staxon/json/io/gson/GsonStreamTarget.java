/*
 * Copyright 2011 Odysseus Software GmbH
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
 */
package de.odysseus.staxon.json.io.gson;

import java.io.IOException;

import com.google.gson.stream.JsonWriter;

import de.odysseus.staxon.json.io.JsonStreamTarget;

class GsonStreamTarget implements JsonStreamTarget {
	private final JsonWriter writer;
	
	GsonStreamTarget(JsonWriter writer) {
		this.writer = writer;
	}

	@Override
	public void endArray() throws IOException {
		writer.endArray();
	}

	@Override
	public void endObject() throws IOException {
		writer.endObject();
	}

	@Override
	public void name(String name) throws IOException {
		writer.name(name);
	}

	@Override
	public void startArray() throws IOException {
		writer.beginArray();
	}

	@Override
	public void startObject() throws IOException {
		writer.beginObject();
	}

	@Override
	public void value(String value) throws IOException {
		if (value == null) {
			writer.nullValue();
		} else {
			writer.value(value);
		}
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}
	
	@Override
	public void close() throws IOException {
		writer.close();
	}
}