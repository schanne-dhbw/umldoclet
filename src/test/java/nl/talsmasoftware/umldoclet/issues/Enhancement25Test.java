/*
 * Copyright 2016-2017 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.talsmasoftware.umldoclet.issues;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests <a href="https://github.com/talsma-ict/umldoclet/issues/25">enhancement 25</a>:
 * Send images to a single directory.
 * <p>
 * The maven job is configured so that it creates a directory called <code>test-uml</code> in the target
 * where images should be located in a single <code>images</code> directory.
 *
 * @author Sjoerd Talsma
 */
@Ignore // Cannot create uml javadoc yet..
public class Enhancement25Test {

    @Test
    public void testImagesDirectoryPresence() {
        File imagesDir = new File("target/test-uml/images");
        assertThat("images dir exists", imagesDir.exists(), is(true));
        assertThat("images dir is directory", imagesDir.isDirectory(), is(true));
    }

    @Test
    public void testEnhancement25ImagePresence() {
        File imageFile = new File("target/test-uml/images/" + getClass().getName() + ".png");
        assertThat("image exists", imageFile.exists(), is(true));
        assertThat("image is directory", imageFile.isDirectory(), is(false));
        assertThat("image is file", imageFile.isFile(), is(true));
    }

}
