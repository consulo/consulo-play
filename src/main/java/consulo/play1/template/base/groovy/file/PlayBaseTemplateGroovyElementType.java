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

package consulo.play1.template.base.groovy.file;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.plugins.groovy.GroovyLanguage;
import org.jetbrains.plugins.groovy.lang.lexer.GroovyLexer;
import org.jetbrains.plugins.groovy.lang.parser.GroovyParser;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IFileElementType;
import consulo.lang.LanguageVersion;
import consulo.lang.util.LanguageVersionUtil;

/**
 * @author VISTALL
 * @since 21:34/23.03.13
 */
public class PlayBaseTemplateGroovyElementType extends IFileElementType
{
	public PlayBaseTemplateGroovyElementType(@Nonnull @NonNls String debugName)
	{
		super(debugName, GroovyLanguage.INSTANCE);
	}

	@Override
	public ASTNode parseContents(ASTNode chameleon)
	{
		PsiElement parentElement = chameleon.getPsi();
		Project project = JavaPsiFacade.getInstance(parentElement.getProject()).getProject();

		Language groovyLanguage = GroovyLanguage.INSTANCE;
		LanguageVersion defaultVersion = LanguageVersionUtil.findDefaultVersion(groovyLanguage);
		PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project, chameleon, new GroovyLexer(), groovyLanguage, defaultVersion, chameleon.getText());

		return new GroovyParser().parse(this, builder, defaultVersion).getFirstChildNode();
	}
}
