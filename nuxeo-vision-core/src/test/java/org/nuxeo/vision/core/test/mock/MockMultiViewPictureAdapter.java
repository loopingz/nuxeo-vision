/*
 * (C) Copyright 2016 Nuxeo SA (http://nuxeo.com/) and others.
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
 * Contributors:
 *     Michael Vachette
 */
package org.nuxeo.vision.core.test.mock;

import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.platform.picture.api.PictureView;
import org.nuxeo.ecm.platform.picture.api.PictureViewImpl;
import org.nuxeo.ecm.platform.picture.api.adapters.MultiviewPictureAdapter;

/**
 * Created by Michaël on 3/8/2016.
 */
public class MockMultiViewPictureAdapter extends MultiviewPictureAdapter {

    private DocumentModel doc;

    public MockMultiViewPictureAdapter(DocumentModel docModel) {
        super(docModel);
        doc = docModel;
    }

    @Override
    public PictureView getView(String title) {
        PictureView view = new PictureViewImpl();
        view.setTitle(title);
        view.setBlob((Blob) doc.getPropertyValue("file:content"));
        return view;
    }
}
