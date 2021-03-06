/*
 * Copyright 2013-2016 consulo.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package consulo.play1.route;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.ex.FileTypeIdentifiableByVirtualFile;
import com.intellij.openapi.vfs.VirtualFile;
import consulo.play1.PlayJavaConstants;
import consulo.ui.image.Image;

/**
 * @author VISTALL
 * @since 21:46/23.03.13
 */
public class PlayRouteFileType extends LanguageFileType implements FileTypeIdentifiableByVirtualFile
{
	public static final LanguageFileType INSTANCE = new PlayRouteFileType();

	protected PlayRouteFileType()
	{
		super(PlayRouteLanguage.INSTANCE);
	}

	@Nonnull
	@Override
	public String getId()
	{
		return "Play Route File";
	}

	@Nonnull
	@Override
	public String getDescription()
	{
		return getId();
	}

	@Nonnull
	@Override
	public String getDefaultExtension()
	{
		return "";
	}

	@Nullable
	@Override
	public Image getIcon()
	{
		return AllIcons.Hierarchy.Class;
	}

	@Override
	public boolean isMyFileType(VirtualFile file)
	{
		return file.getName().equalsIgnoreCase(PlayJavaConstants.ROUTES) && file.getParent().getName().equalsIgnoreCase(PlayJavaConstants.CONF);
	}
}
