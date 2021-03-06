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

package consulo.play1.template.base.editor.highlight;

import consulo.play1.template.base.parser.PlayBaseTemplateTokens;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.plugins.groovy.highlighter.GroovySyntaxHighlighter;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataHighlighterWrapper;

/**
 * @author VISTALL
 * @since 19:58/18.03.13
 */
public class PlayBaseTemplateEditorHighlighter extends LayeredLexerEditorHighlighter
{
	public PlayBaseTemplateEditorHighlighter(@Nonnull EditorColorsScheme scheme, @Nullable Project project, @Nullable VirtualFile virtualFile)
	{
		super(new PlayBaseTemplateSyntaxHighlighter(), scheme);

		SyntaxHighlighter htmlHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(HTMLLanguage.INSTANCE, project, virtualFile);
		LayerDescriptor htmlLayer = new LayerDescriptor(new TemplateDataHighlighterWrapper(htmlHighlighter), "\n");
		registerLayer(PlayBaseTemplateTokens.TEMPLATE_TEXT, htmlLayer);

		SyntaxHighlighter groovyHighlighter = new GroovySyntaxHighlighter();
		LayerDescriptor groovyLayer = new LayerDescriptor(groovyHighlighter, "\n", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);

		registerLayer(PlayBaseTemplateTokens.GROOVY_EXPRESSION_OLD, groovyLayer);
	}
}
