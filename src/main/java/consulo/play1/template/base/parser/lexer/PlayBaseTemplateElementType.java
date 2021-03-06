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

package consulo.play1.template.base.parser.lexer;

import java.lang.reflect.Constructor;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;
import consulo.play1.template.base.PlayBaseTemplateLanguage;
import consulo.play1.template.base.psi.PlayBaseTemplateElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 14:58/18.03.13
 */
public class PlayBaseTemplateElementType extends IElementType
{
	private final Constructor<? extends PlayBaseTemplateElement> constructor;

	public PlayBaseTemplateElementType(@Nonnull @NonNls String debugName)
	{
		this(debugName, PlayBaseTemplateElement.class);
	}

	public PlayBaseTemplateElementType(@Nonnull @NonNls String debugName, Class<? extends PlayBaseTemplateElement> clazz)
	{
		super(debugName, PlayBaseTemplateLanguage.INSTANCE);

		try
		{
			constructor = clazz.getConstructor(ASTNode.class);
		}
		catch(NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
	}

	public PsiElement createPsiElement(ASTNode node)
	{
		try
		{
			return constructor.newInstance(node);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
