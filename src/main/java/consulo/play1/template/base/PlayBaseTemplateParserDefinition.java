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

package consulo.play1.template.base;

import javax.annotation.Nonnull;

import consulo.play1.template.base.parser.PlayBaseTemplateTokenSets;
import consulo.play1.template.base.parser.PlayBaseTemplateTokens;
import consulo.play1.template.base.parser.lexer.PlayBaseTemplateElementType;
import consulo.play1.template.base.parser.lexer.PlayBaseTemplateLexer;
import consulo.play1.template.base.psi.PlayBaseTemplateFile;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;

/**
 * @author VISTALL
 * @since 12:07/18.03.13
 */
public class PlayBaseTemplateParserDefinition implements ParserDefinition
{
	@Nonnull
	@Override
	public Lexer createLexer(LanguageVersion languageVersion)
	{
		return new PlayBaseTemplateLexer();
	}

	@Override
	public PsiParser createParser(LanguageVersion languageVersion)
	{
		return PlayBaseTemplateParser.INSTANCE;
	}

	@Override
	public IFileElementType getFileNodeType()
	{
		return PlayBaseTemplateTokens.PLAY_BASE_TEMPLATE_FILE;
	}

	@Nonnull
	@Override
	public TokenSet getWhitespaceTokens(LanguageVersion languageVersion)
	{
		return PlayBaseTemplateTokenSets.WHITESPACE_SET;
	}

	@Nonnull
	@Override
	public TokenSet getCommentTokens(LanguageVersion languageVersion)
	{
		return PlayBaseTemplateTokenSets.COMMENT_SET;
	}

	@Nonnull
	@Override
	public TokenSet getStringLiteralElements(LanguageVersion languageVersion)
	{
		return PlayBaseTemplateTokenSets.STRING_SET;
	}

	@Nonnull
	@Override
	public PsiElement createElement(ASTNode node)
	{
		final IElementType elementType = node.getElementType();

		if(elementType instanceof PlayBaseTemplateElementType)
		{
			return ((PlayBaseTemplateElementType) elementType).createPsiElement(node);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new PlayBaseTemplateFile(viewProvider);
	}

	@Override
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		return SpaceRequirements.MAY;
	}
}
