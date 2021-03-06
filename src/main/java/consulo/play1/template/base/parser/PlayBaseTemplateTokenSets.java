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

package consulo.play1.template.base.parser;

import com.intellij.psi.tree.TokenSet;

/**
 * @author VISTALL
 * @since 18:31/18.03.13
 */
public interface PlayBaseTemplateTokenSets extends PlayBaseTemplateTokens
{
	TokenSet TEMPLATE_ELEMENTS = TokenSet.create(EXPRESSION_START, SCRIPT_START, TAG_START, MESSAGE_START, ACTION_START, ABSOLUTE_ACTION_START, CLOSE_BRACE, TAG_END, SCRIPT_END);

	TokenSet STRING_SET = TokenSet.create(STRING);

	TokenSet COMMENT_SET = TokenSet.create(COMMENT);

	TokenSet WHITESPACE_SET = TokenSet.create(WHITE_SPACE);
}
